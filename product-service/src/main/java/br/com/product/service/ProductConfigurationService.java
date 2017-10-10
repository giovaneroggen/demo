package br.com.product.service;

import br.com.product.data.ProductConfiguration;
import br.com.product.data.Simple;
import br.com.product.data.projection.SimpleEcommerceProjection;
import br.com.product.data.repository.ProductConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Service
public class ProductConfigurationService {

    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;

    public void processSimple(String productId, Double productPrice, Optional<Long> stockRequired, BiConsumer<Double, Boolean> biConsumer) {
        ProductConfiguration one = this.productConfigurationRepository.findOne(productId);
        Double price = this.resolveCurrentPrice(productPrice, one.getPrice());
        Boolean stock = this.resolveStock(price, one.getStock(), stockRequired);

        biConsumer.accept(price, stock);
    }

    private Boolean resolveStock(Double price, Long stock, Optional<Long> stockRequired) {
        return this.isValidPrice(price) && this.isValidStock(stock, stockRequired);
    }

    private Double resolveCurrentPrice(Double defaultPrice, Double price) {
        if(this.isValidPrice(price)){
            return price;
        }
        return defaultPrice;
    }

    private boolean isValidPrice(Double price) {
        return price != null && price > 0;
    }

    private boolean isValidStock(Long stock, Optional<Long> stockRequired) {
        return stock != null &&
               this.isValidStockRequired(stock, stockRequired);
    }

    private boolean isValidStockRequired(Long stock, Optional<Long> stockRequired) {
        if(stockRequired.isPresent())
            return stockRequired.get() > stock;
        return stock > 0;
    }
}

package br.com.product.service;

import br.com.product.data.Kit;
import br.com.product.data.KitItem;
import br.com.product.data.Product;
import br.com.product.data.Simple;
import br.com.product.data.repository.ProductRepository;
import br.com.product.enummeration.ProductTypeEnum;
import br.com.product.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConfigurationService productConfigurationService;

    public void processSimple(String id, Double price, Optional<Long> stockRequired, BiConsumer<Double, Boolean> biConsumer) {
        this.productConfigurationService.processSimple(id, price, stockRequired, biConsumer);
    }

    public void processKit(List<KitItem> kitItemList, BiConsumer<Double, Boolean> biConsumer) {
        final Wrapper<Double> price = Wrapper.instance(0.0);
        final Wrapper<Boolean> stock = Wrapper.instance(true);
        kitItemList.forEach(item ->
            this.processKitItem(price, stock, item)
        );
        biConsumer.accept(price.getValue(), stock.getValue());
    }

    private void processKitItem(Wrapper<Double> priceTotal, Wrapper<Boolean> stockFinal, KitItem ki) {
        Product item = this.productRepository.findOne(ki.getProductId());
        this.processSimple(ki.getProductId(), item.getPrice(), Optional.of(ki.getQuantity()), (price, stock) ->
            this.resolveKitStockAndPrice(priceTotal, stockFinal, ki, price, stock)
        );
    }

    private void resolveKitStockAndPrice(Wrapper<Double> priceTotal, Wrapper<Boolean> stockFinal, KitItem ki, Double price, Boolean stock) {
        if(stock){
            Double total = priceTotal.getValue() + price * ki.getQuantity();
            priceTotal.setValue(total);
        }else{
            stockFinal.setValue(Boolean.FALSE);
        }
    }

    public List<Product> findAllProductsByKitItemList(List<KitItem> items) {
        return this.productRepository.findByIdIn(this.collectKitItemList(items));
    }

    private List<String> collectKitItemList(List<KitItem> items) {
        return items.stream()
                .map(KitItem::getProductId)
                .collect(Collectors.toList());
    }
}

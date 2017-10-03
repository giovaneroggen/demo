package br.com.basket.service;

import br.com.basket.messaging.queues.ProcessBasketQueue;
import br.com.feign.request.basket.BasketRequest;
import br.com.feign.response.basket.BasketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Service
public class BasketService {

    @Autowired
    private ProcessBasketQueue processBasketQueue;

    public BasketResponse processMocked(BasketRequest request) {
        return BasketResponse.fromRequestMock(request);
    }

    public String processId() {
        return UUID.randomUUID().toString();
    }

    public void sendProcessToQueue(String uuid, BasketRequest request) {
        this.processBasketQueue.output().send(
            MessageBuilder.withPayload(request)
                          .setHeader("uuid", uuid)
                          .build()
        );
    }
}

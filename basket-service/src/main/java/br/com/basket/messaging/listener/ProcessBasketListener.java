package br.com.basket.messaging.listener;

import br.com.basket.messaging.queues.ProcessBasketQueue;
import br.com.basket.service.BasketService;
import br.com.feign.request.basket.BasketRequest;
import br.com.feign.response.basket.BasketResponse;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Component
public class ProcessBasketListener {

    @Autowired
    private BasketService basketService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ApplicationContext context;

    @StreamListener(ProcessBasketQueue.PROCESS_BASKET_INPUT)
    public void receiveMessage(@Header("uuid") String uuid, @Payload BasketRequest request){
        BasketResponse response = this.basketService.processMocked(request);
        this.sendResponseToCustomerQueue(this.queueName(uuid), response);
    }

    private void sendResponseToCustomerQueue(String queueName, BasketResponse response) {
        this.declareQueue(new Queue(queueName, true));
        this.rabbitTemplate.convertAndSend(queueName, response);
    }

    /**
     * Método criado para garantir que a fila estará declarada
     * @param queue
     */
    private void declareQueue(Queue queue) {
        context.getBean(RabbitAdmin.class).declareQueue(queue);
    }

    private String queueName(String uuid) {
        return ProcessBasketQueue.PROCESS_BASKET + "-" + uuid;
    }

}

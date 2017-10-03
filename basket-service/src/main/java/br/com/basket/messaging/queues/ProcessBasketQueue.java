package br.com.basket.messaging.queues;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by giovane.silva on 04/09/2017.
 */
public interface ProcessBasketQueue {

    String PROCESS_BASKET = "process-basket";
    String PROCESS_BASKET_INPUT  = PROCESS_BASKET+"-input";
    String PROCESS_BASKET_OUTPUT = PROCESS_BASKET+"-output";

    @Output(PROCESS_BASKET_OUTPUT)
    MessageChannel output();

    @Input(PROCESS_BASKET_INPUT)
    SubscribableChannel input();
}

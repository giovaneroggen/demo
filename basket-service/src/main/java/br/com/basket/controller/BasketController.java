package br.com.basket.controller;

import br.com.basket.service.BasketService;
import br.com.feign.request.basket.BasketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@RestController
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping("/process")
    public ResponseEntity process(@RequestHeader("uuid") String uuid, @RequestBody @Valid BasketRequest request) {
        this.basketService.sendProcessToQueue(uuid, request);
        return ResponseEntity
                .accepted()
                .build();
    }


    @GetMapping("/uuid")
    public String generateUUID() {
        return this.basketService.processId();
    }

}

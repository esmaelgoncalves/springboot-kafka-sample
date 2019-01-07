package br.com.egoncalves.springbootkafkasample.controller;

import br.com.egoncalves.springbootkafkasample.dto.Message;
import br.com.egoncalves.springbootkafkasample.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        this.producerService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}

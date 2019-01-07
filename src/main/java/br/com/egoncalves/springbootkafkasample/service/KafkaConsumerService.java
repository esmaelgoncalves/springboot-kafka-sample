package br.com.egoncalves.springbootkafkasample.service;

import br.com.egoncalves.springbootkafkasample.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(id = "springboot-kafka-consumer3", topics = "springboot-kafka-topic", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String, String> message) {
        log.info("Message received: {}", message);
    }
}

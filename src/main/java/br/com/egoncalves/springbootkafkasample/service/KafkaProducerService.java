package br.com.egoncalves.springbootkafkasample.service;

import br.com.egoncalves.springbootkafkasample.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(Message message) {

        kafkaTemplate.send(new ProducerRecord<>("springboot-kafka-topic", null, message))
                .addCallback(new ListenableFutureCallback<SendResult<Integer, Message>>() {
                    @Override
                    public void onSuccess(SendResult<Integer, Message> result) {
                        log.info("Message saved into topic {}, partition {}",
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().partition());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        log.error("Something going wrong. =(", throwable);
                    }

                });
    }
}

package com.kafka.kafkaspring;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MRestController {

    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/send/{message}/{topic}")
    public String send(@PathVariable String message,
                       @PathVariable String topic){
        kafkaTemplate.send(topic,"key"+message.length(),message);
        return "Données envoyées!";
    }
}

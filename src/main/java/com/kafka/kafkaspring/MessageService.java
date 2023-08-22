package com.kafka.kafkaspring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @KafkaListener(topics = "test4",groupId = "groupe-msg")
    public void onMessage(ConsumerRecord<String,String> cr){
        System.out.println("****************************************");
        System.out.println(cr.key()+"=>"+cr.value());
        System.out.println("********************************************");
    }
}

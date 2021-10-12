package com.techbuddy.apachekafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisherController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public static final String TOPIC = "TestTopic";

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") String message){
        kafkaTemplate.send(TOPIC, message);
        return "Published Successfully!";
    }

    @GetMapping("/publishJson")
    public String publishMessage(){
        Book book = new Book("Microservices in action", "456787654");
        kafkaTemplate.send(TOPIC, book.toString());
        return "JSON data published Successfully!!";
    }
}

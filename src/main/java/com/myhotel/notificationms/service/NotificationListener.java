package com.myhotel.notificationms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myhotel.notificationms.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@Service
public class NotificationListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${system.notificationTopic}")
    public void listen(String value,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        logger.info(String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));
        try {
            Message message = objectMapper.readValue(value,  Message.class);
            logger.info("Message: " + message);
            //Send mail to notify the user
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

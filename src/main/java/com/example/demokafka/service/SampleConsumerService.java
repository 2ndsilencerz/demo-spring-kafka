package com.example.demokafka.service;

import com.example.demokafka.model.SampleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumerService {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static final String groupId = "demokafkagroup";

    @KafkaListener(topics = SampleProducerService.topic, groupId = groupId)
    public void consume(SampleModel message) {
        logger.info("incoming: " + message.getMessage());
    }
}

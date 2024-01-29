package com.example.demokafka.service;

import com.example.demokafka.model.SampleModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SampleProducerService {

//    Logger logger = LoggerFactory.getLogger(getClass());
    public static final String topic = "demo";

    final KafkaTemplate<String, Object> kafkaTemplate;

    public SampleProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public SampleModel testInput(SampleModel model) {
        Random rng = new Random();
        if (model == null) {
            model = new SampleModel();
            model.setMessage("");
        }

        Long rngResult = rng.nextLong();
//        model.setId(rngResult);
        model.setMessage(model.getMessage().concat(String.valueOf(rngResult)));
        kafkaTemplate.send(topic, model);
        return model;
    }
}

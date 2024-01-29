package com.example.demokafka.controller;

import com.example.demokafka.model.SampleModel;
import com.example.demokafka.service.SampleProducerService;
import org.springframework.web.bind.annotation.*;

@RestController("/test")
public class SampleController {

    final SampleProducerService service;

    public SampleController(SampleProducerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/input/get")
    public SampleModel testInputByGet() {
        return service.testInput(null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/input/post")
    public SampleModel testInputByPost(@RequestBody SampleModel model) {
        return service.testInput(model);
    }
}

package com.goodrain.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/sleuth")
public class SleuthController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SleuthController.class);
	
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public String index() {
    	LOGGER.info("Request to /demo/show endpoint");
        ResponseEntity<String> entity = restTemplate.getForEntity("http://DEMO-SERVICE/demo/show", String.class);
        LOGGER.info("/demo/show response");
        return entity.getBody();
    }
}

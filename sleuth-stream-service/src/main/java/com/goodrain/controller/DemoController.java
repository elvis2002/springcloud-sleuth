package com.goodrain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	
    @RequestMapping("/")
    public String index() {
    	LOGGER.info("Request to / endpoint");
        return "sleuth index";
    }
}

package com.goodrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SleuthDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthDemoApplication.class, args);
    }
    
    @Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
    
    @Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}

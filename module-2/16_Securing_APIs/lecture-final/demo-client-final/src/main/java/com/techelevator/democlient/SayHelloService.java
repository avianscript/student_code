package com.techelevator.democlient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SayHelloService {

    private RestTemplate restTemplate = new RestTemplate();

    public String sayHello(String name) {
       return restTemplate.getForObject("http://localhost:8080/sayhello?name=" + name, String.class);
    }
}

package com.techelevator.memes;

import com.techelevator.memes.service.MemeGeneratorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemesGeneratorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemesGeneratorApiApplication.class, args);
    }

}

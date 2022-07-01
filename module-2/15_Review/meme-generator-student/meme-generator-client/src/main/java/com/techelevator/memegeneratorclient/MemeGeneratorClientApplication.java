package com.techelevator.memegeneratorclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemeGeneratorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemeGeneratorClientApplication.class, args);

        MemeGeneratorClientCLI cli = new MemeGeneratorClientCLI();
        cli.run();
    }

}

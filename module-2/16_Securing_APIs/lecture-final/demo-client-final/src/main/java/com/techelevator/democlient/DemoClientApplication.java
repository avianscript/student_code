package com.techelevator.democlient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoClientApplication {

	public void run() {
		SayHelloService sayHelloService = new SayHelloService();
		String result = sayHelloService.sayHello("Linda");
		System.out.println(result);
		System.exit(1);
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoClientApplication.class, args);

		DemoClientApplication app = new DemoClientApplication();
		app.run();
	}



}

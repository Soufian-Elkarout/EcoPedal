package com.ecoPedal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   // Active les tâches @Scheduled (ex: expireReservationsExpirees)
public class EcoPedalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoPedalApplication.class, args);
		System.out.println("Hello world !!");
	}

}

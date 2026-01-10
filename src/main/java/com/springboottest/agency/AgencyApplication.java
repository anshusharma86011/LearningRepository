package com.springboottest.agency;

import java.time.ZoneId;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;       


@SpringBootApplication
public class AgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgencyApplication.class, args);
		System.out.println("Inventory Application is Running");
		

		//System.out.println("Java Time: " + new Date());
        //System.out.println("Java Zone: " + ZoneId.systemDefault());



	}
}

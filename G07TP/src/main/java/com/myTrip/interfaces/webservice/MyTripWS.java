package com.myTrip.interfaces.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.myTrip"})
public class MyTripWS
{
	public static void main(String[] args)
	{
		SpringApplication.run(MyTripWS.class, args);
	}
}
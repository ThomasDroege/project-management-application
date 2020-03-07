package com.thomas.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//Need to be set to @Configuration to tell spring to run this class
@Configuration
public class ManufactureConfig {

	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		return new Car(e, d, t);
	}
	
}

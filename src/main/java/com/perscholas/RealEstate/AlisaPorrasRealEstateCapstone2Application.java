package com.perscholas.RealEstate;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AlisaPorrasRealEstateCapstone2Application
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext applicationContext
		    = SpringApplication.run(AlisaPorrasRealEstateCapstone2Application.class, args);


		System.out.println("COMPLETED Alisa");

	}//main () end



	@Bean
	public CommandLineRunner commandLineRunner1()
	{
		CommandLineRunner commandLineRunner = args1 -> System.out.println("BTB Properties application started");
		return  commandLineRunner;
	}
}//class end



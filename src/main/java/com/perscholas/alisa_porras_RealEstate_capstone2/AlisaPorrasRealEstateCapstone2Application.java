package com.perscholas.alisa_porras_RealEstate_capstone2;

//import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Customer;
//import com.perscholas.alisa_porras_RealEstate_capstone2.repositories.CustomerRepository;
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
		CommandLineRunner commandLineRunner = args1 -> System.out.println("this is my 1st commandline runner");
		return  commandLineRunner;
	}
}//class end




//		CustomerRepository customerRepository
//				= applicationContext.getBean(CustomerRepository.class);

//		DepartmentRepository departmentRepository
//				= applicationContext.getBean(DepartmentRepository.class);



		//adding records to customer table
//		Customer tina = new Customer("Tina", "222 hello you ave.","nowhere", "oh",42358);
//		customerRepository.save(tina);
//		Customer joe = new Customer("Joe", "541 goodbye you ave.","somewhere", "oh",43588);
//		customerRepository.save(joe);
//		Customer alisa = new Customer("Alisa", "847 outtie ave.","homebound", "oh",43236);
//		customerRepository.save(alisa);

//		//get all records in customer table
//		List<Department> departments = departmentRepository.findAll();
//		System.out.println("LIST OF Departments: " + departments);

		//		//get all records in customer table
//		List<Customer> customers = customerRepository.findAll();
//		System.out.println("LIST OF CUSTOMERS: " + customers);


//		//get specific records from customer table
//		Customer customers = customerRepository.findFirstByName("tina");
//		System.out.println("SPECIFIC CUSTOMER: " + customers);

//		Customer customers = customerRepository.findFirstByName("sang");
//		System.out.println("CUSTOMERS: " + customers);


//		List<Customer> customers = customerRepository.findByName("sang");
//		System.out.println("CUSTOMERS: " + customers);

//		List<Customer> customers = customerRepository.findByNameAndAge("sang", 30);
//		System.out.println("CUSTOMERS NAME AND AGE: " + customers);




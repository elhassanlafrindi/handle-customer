package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository repository, RepositoryRestConfiguration config) {
		return args -> {
			config.exposeIdsFor(Customer.class);
			repository.deleteAll();
			repository.saveAll(
					List.of(
							Customer.builder().name("taha").email("taha").build()
					)
			);
repository.findAll().forEach(c-> System.out.println(c.getName()));
		};
	}
}

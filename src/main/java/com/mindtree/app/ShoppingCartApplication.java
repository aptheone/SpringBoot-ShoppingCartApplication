package com.mindtree.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author M1016253
 *
 */
@EnableJpaRepositories("com.mindtree.app.repository") 
@EntityScan("com.mindtree.app.model")
@EnableTransactionManagement
@SpringBootApplication
public class ShoppingCartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
}

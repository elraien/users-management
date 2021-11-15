package com.restapi.usersmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsersManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersManagementApplication.class, args);
	}

}

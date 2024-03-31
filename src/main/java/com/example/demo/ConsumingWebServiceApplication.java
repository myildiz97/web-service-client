package com.example.demo;

import com.example.demo.client.gen.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(UserClient userClient) {
		return args -> {
			User user = new User();
			user.setName("Client");
			user.setBirthday("01.02.1993");
			user.setAccountNo(19932);
			user.setBankName("Client Bankası");
			user.setCompanyName("Client Company");
			user.setEmail("client@client.com");
			user.setGender(Gender.MALE);
			user.setRole(Role.CUSTOMER);
			user.setPassword("client123");
			user.setPhone("0555 555 55 55");
			user.setUsername("clientTest");

			SignupUserResponse response1 = userClient.signupUser(user);
			System.out.println("User created.");
			System.out.println(response1.getSuccess());

			LoginUserResponse response2 = userClient.loginUser("sdenizu", "123deniz");
			System.out.println("Login existed user with correct password.");
			System.out.println(response2.getSuccess());

			LoginUserResponse response3 = userClient.loginUser("clientTest", "client123");
			System.out.println("Login newly created user with correct password.");
			System.out.println(response3.getSuccess());
		};
	}
}

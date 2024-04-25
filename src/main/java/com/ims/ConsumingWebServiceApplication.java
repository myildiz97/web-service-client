package com.ims;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ims.client.gen.*;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(UserClient userClient) throws Exception {
		return args -> {
			User validUser = new User();
			validUser.setName("Client");
			validUser.setBirthday("01.02.1993");
			validUser.setAccountNo(19932);
			validUser.setBankName("Client Bankasi");
			validUser.setCompanyName("Client Company");
			validUser.setEmail("client@client.com");
			validUser.setGender(Gender.MALE);
			validUser.setRole(Role.CUSTOMER);
			validUser.setPassword("client123");
			validUser.setPhone("0555 555 55 55");
			validUser.setUsername("clientTest");
			try {
				System.out.println("***Trying to create a new valid user.");
				SignupUserResponse response = userClient.signupUser(validUser);
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Trying to create the same valid user again.");
				SignupUserResponse response = userClient.signupUser(validUser);
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			User userNameShortUser = new User();
			userNameShortUser.setName("Client");
			userNameShortUser.setBirthday("01.02.1993");
			userNameShortUser.setAccountNo(19932);
			userNameShortUser.setBankName("Client Bankasi");
			userNameShortUser.setCompanyName("Client Company");
			userNameShortUser.setEmail("client@client.com");
			userNameShortUser.setGender(Gender.MALE);
			userNameShortUser.setRole(Role.CUSTOMER);
			userNameShortUser.setPassword("client123");
			userNameShortUser.setPhone("0555 555 55 55");
			userNameShortUser.setUsername("ab");
			try {
				System.out.println("***Trying to create a new user with a short name (ab).");
				SignupUserResponse response = userClient.signupUser(userNameShortUser);
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			User passwordShortUser = new User();
			passwordShortUser.setName("Client");
			passwordShortUser.setBirthday("01.02.1993");
			passwordShortUser.setAccountNo(19932);
			passwordShortUser.setBankName("Client Bankasi");
			passwordShortUser.setCompanyName("Client Company");
			passwordShortUser.setEmail("client@client.com");
			passwordShortUser.setGender(Gender.MALE);
			passwordShortUser.setRole(Role.CUSTOMER);
			passwordShortUser.setPassword("12345");
			passwordShortUser.setPhone("0555 555 55 55");
			passwordShortUser.setUsername("shortPasswordUser");
			try {
				System.out.println("***Trying to create a new user with a short password (12345).");
				SignupUserResponse response = userClient.signupUser(passwordShortUser);
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Login existed user with correct password.");
				LoginUserResponse response = userClient.loginUser("sdenizu", "123deniz");
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Login newly created user with correct password.");
				LoginUserResponse response = userClient.loginUser("clientTest", "client123");
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Login newly created user with incorrect password.");
				LoginUserResponse response = userClient.loginUser("clientTest", "1111111");
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Login a user that does not exists.");
				LoginUserResponse response = userClient.loginUser("notExistedUser", "123123");
				System.out.println("***Success message:");
				System.out.println(response.getSuccess());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}

		};
	}
}

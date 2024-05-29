package com.ims;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ims.restModel.UserRecord;
import com.ims.restModel.LoginRequest;
import com.ims.restModel.User;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingWebServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			try {
				System.out.println("***Login SUPPLIER");
				String username = "sdenizu";
				String password = "123deniz";
				LoginRequest loginRequest = new LoginRequest();
				loginRequest.setUsername(username);
				loginRequest.setPassword(password);
				ResponseEntity<String> response = restTemplate.postForEntity(
						"http://localhost:8080/users/login",
						loginRequest,
						String.class);
				System.out.println("***Success message:");
				System.out.println(response.getStatusCodeValue());
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Login IMPORT MANAGER");
				String username = "uoztop";
				String password = "umut987";
				LoginRequest loginRequest = new LoginRequest();
				loginRequest.setUsername(username);
				loginRequest.setPassword(password);
				ResponseEntity<String> response = restTemplate.postForEntity(
						"http://localhost:8080/users/login",
						loginRequest,
						String.class);
				System.out.println("***Success message:");
				System.out.println(response.getStatusCodeValue());
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				System.out.println("***Login CUSTOMER");
				String username = "mehmetyildiz";
				String password = "mehmet123";
				LoginRequest loginRequest = new LoginRequest();
				loginRequest.setUsername(username);
				loginRequest.setPassword(password);
				ResponseEntity<String> response = restTemplate.postForEntity(
						"http://localhost:8080/users/login",
						loginRequest,
						String.class);
				System.out.println("***Success message:");
				System.out.println(response.getStatusCodeValue());
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:8080/users/grpc/capability/CUSTOMER",
						String.class);
				System.out.println("***Success message:");
				System.out.println(response.getStatusCodeValue());
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				ResponseEntity<?> response = restTemplate.getForEntity(
						"http://localhost:8080/users/grpc/capability/IMPORT_MANAGER",
						String.class);
				System.out.println("***Success message:");
				System.out.println(response.getStatusCodeValue());
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			try {
				ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:8080/users/grpc/capability/SUPPLIER",
						String.class);
				System.out.println("***Success message:");
				System.out.println(response.getStatusCodeValue());
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.out.println("***Error message:");
				System.out.println(e.getMessage());
			}
			System.out.println("---------------");

			// try {
			// ResponseEntity<UserRecord> response =
			// restTemplate.getForEntity("http://localhost:8080/users/10",
			// UserRecord.class);
			// log.info(response.toString());
			// } catch (Exception e) {
			// log.error(e.getMessage());
			// }

			// User validUser = new User();
			// validUser.setName("Client");
			// validUser.setBirthDate("01.02.1993");
			// validUser.setAccountNumber(19932);
			// validUser.setBankName("Client Bankasi");
			// validUser.setCompanyName("Client Company");
			// validUser.setEmail("client@client.com");
			// validUser.setGender(User.Gender.MALE);
			// validUser.setRole(User.UserRoles.CUSTOMER);
			// validUser.setPassword("client123");
			// validUser.setPhone("0555 555 55 55");
			// validUser.setUsername("clientTest");

			// try {
			// System.out.println("***Trying to create a new valid user.");
			// ResponseEntity<UserRecord> response =
			// restTemplate.postForEntity("http://localhost:8080/users/signup",
			// validUser, UserRecord.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody().toString());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// User userNameShortUser = new User();
			// userNameShortUser.setName("Client");
			// userNameShortUser.setBirthDate("01.02.1993");
			// userNameShortUser.setAccountNumber(19932);
			// userNameShortUser.setBankName("Client Bankasi");
			// userNameShortUser.setCompanyName("Client Company");
			// userNameShortUser.setEmail("client@client.com");
			// userNameShortUser.setGender(User.Gender.MALE);
			// userNameShortUser.setRole(User.UserRoles.CUSTOMER);
			// userNameShortUser.setPassword("client123");
			// userNameShortUser.setPhone("0555 555 55 55");
			// userNameShortUser.setUsername("ab");

			// try {
			// System.out.println("***Trying to create a new user with a short name (ab).");
			// ResponseEntity<UserRecord> response =
			// restTemplate.postForEntity("http://localhost:8080/users/signup",
			// userNameShortUser, UserRecord.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// User passwordShortUser = new User();
			// passwordShortUser.setName("Client");
			// passwordShortUser.setBirthDate("01.02.1993");
			// passwordShortUser.setAccountNumber(19932);
			// passwordShortUser.setBankName("Client Bankasi");
			// passwordShortUser.setCompanyName("Client Company");
			// passwordShortUser.setEmail("client@client.com");
			// passwordShortUser.setGender(User.Gender.MALE);
			// passwordShortUser.setRole(User.UserRoles.CUSTOMER);
			// passwordShortUser.setPassword("12345");
			// passwordShortUser.setPhone("0555 555 55 55");
			// passwordShortUser.setUsername("shortPasswordUser");
			// try {
			// System.out.println("***Trying to create a new user with a short password
			// (12345).");
			// ResponseEntity<UserRecord> response =
			// restTemplate.postForEntity("http://localhost:8080/users/signup",
			// passwordShortUser, UserRecord.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// try {
			// System.out.println("***Login newly created user with correct password.");
			// String username = validUser.getUsername();
			// String password = validUser.getPassword();
			// LoginRequest loginRequest = new LoginRequest();
			// loginRequest.setUsername(username);
			// loginRequest.setPassword(password);

			// ResponseEntity<String> response = restTemplate.postForEntity(
			// "http://localhost:8080/users/login",
			// loginRequest,
			// String.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// try {
			// System.out.println("***Login newly created user with incorrect password.");
			// String username = validUser.getUsername();
			// String password = "incorrectPassword";

			// LoginRequest loginRequest = new LoginRequest();
			// loginRequest.setUsername(username);
			// loginRequest.setPassword(password);

			// ResponseEntity<String> response = restTemplate.postForEntity(
			// "http://localhost:8080/users/login",
			// loginRequest,
			// String.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// try {
			// System.out.println("***Login a user that already logged in.");
			// String username = "mehmetyildiz";
			// String password = "mehmet123";

			// LoginRequest loginRequest = new LoginRequest();
			// loginRequest.setUsername(username);
			// loginRequest.setPassword(password);
			// ResponseEntity<String> response =
			// restTemplate.postForEntity("http://localhost:8080/users/login", loginRequest,
			// String.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// try {
			// System.out.println("***Login a user that does not exists.");
			// String username = "nonExistedUser";
			// String password = "incorrectPassword";

			// LoginRequest loginRequest = new LoginRequest();
			// loginRequest.setUsername(username);
			// loginRequest.setPassword(password);

			// ResponseEntity<String> response = restTemplate.postForEntity(
			// "http://localhost:8080/users/login",
			// loginRequest,
			// String.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// try {
			// System.out.println("***Logout a user that logged in.");
			// ResponseEntity<String> response =
			// restTemplate.getForEntity("http://localhost:8080/users/1/logout",
			// String.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

			// try {
			// System.out.println("***Logout a user that did not logged in.");
			// ResponseEntity<String> response =
			// restTemplate.getForEntity("http://localhost:8080/users/1/logout",
			// String.class);
			// System.out.println("***Success message:");
			// System.out.println(response.getStatusCodeValue());
			// System.out.println(response.getBody());
			// } catch (Exception e) {
			// System.out.println("***Error message:");
			// System.out.println(e.getMessage());
			// }
			// System.out.println("---------------");

		};
	}

}

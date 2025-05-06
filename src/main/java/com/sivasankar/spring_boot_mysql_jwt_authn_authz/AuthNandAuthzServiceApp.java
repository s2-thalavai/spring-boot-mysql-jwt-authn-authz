package com.sivasankar.spring_boot_mysql_jwt_authn_authz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sivasankar")
public class AuthNandAuthzServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthNandAuthzServiceApp.class, args);
	}

}

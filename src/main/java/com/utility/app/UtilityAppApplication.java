package com.utility.app;

import com.utility.app._dtos.AdminDTO;
import com.utility.app.security.PasswordCoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtilityAppApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(UtilityAppApplication.class, args);
	}
}

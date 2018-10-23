package com.filename.validator;

import com.filename.validator.process.FileNameValidator;
import com.filename.validator.result.FileNameValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class ValidatorApplication implements CommandLineRunner {

	@Autowired
	private FileNameValidator fileNameValidator;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ValidatorApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	public void run(String... args) throws Exception {
		if (args.length > 0) {
			FileNameValidationResult validationResult = fileNameValidator.validateFileName(args[0].toString());
			System.out.println("Validation Status : "+ validationResult.getStatus());
			System.out.println("Message : " + validationResult.getMessage());
		} else {
			System.out.println("Please pass the filename as argument");
		}

	}
}

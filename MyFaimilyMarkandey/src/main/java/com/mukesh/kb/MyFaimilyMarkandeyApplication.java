package com.mukesh.kb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc  //get rid of error :: Failed to start bean 'documentationPluginsBootstrapper' related to swagger
@SpringBootApplication
public class MyFaimilyMarkandeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFaimilyMarkandeyApplication.class, args);
	}

}

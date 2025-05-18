package com.acme.spring_data_entityless_fetching;

import org.springframework.boot.SpringApplication;

public class TestSpringStoredProceduresMssqlApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringDataEntitylessFetchingApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

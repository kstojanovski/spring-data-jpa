package com.acme.spring_data_entityless_fetching;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpringDataEntitylessFetchingApplicationTests {

	@Test
	void contextLoads() {
	}

}

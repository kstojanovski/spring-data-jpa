package com.acme.hibernate6issue

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class Hibernate6issueApplicationTests {

	@Test
	fun contextLoads() {
	}

}

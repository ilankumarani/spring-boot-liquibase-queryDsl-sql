package com.ilan;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Disabled
@ActiveProfiles("multi")
@SpringBootTest
class MultiTest {

	@Test
	void contextLoads() {
	}

}

package io.github.ilankumarani;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;


@Profile("multi")
@SpringBootTest
class MultiTest {

	@Test
	void contextLoads() {
	}

}

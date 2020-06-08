package com.remote.RemoteCommands;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RemoteCommandsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void isWindows() {
		boolean isWindows = System.getProperty("os.name")
				.toLowerCase().startsWith("windows");

		assertTrue(isWindows);
	}

	@Test
	void testCommands() {

	}

}

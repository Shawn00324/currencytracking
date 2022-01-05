package idv.shawn.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idv.shawn.CurrencytrackingApplication;

@SpringBootTest(classes = { CurrencytrackingApplication.class })
public class HelloControllerTest {

	@Autowired
	HelloController helloController;
	
	@Test
	public void testHelloReturnExceptedString() {
		final String excepted = "Hello Currency Tracking!!!";
		final String actual = helloController.hello();
		assertEquals(excepted, actual);
	}
	
	@Test
	public void testHelloReturnUnexceptedString() {
		final String excepted = "hello";
		final String actual = helloController.hello();
		assertNotEquals(excepted, actual);
	}
}

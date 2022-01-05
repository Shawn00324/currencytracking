package idv.shawn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		String s = "Hello Currency Tracking!!!";
		System.out.println(s);
		return s;
	}
}

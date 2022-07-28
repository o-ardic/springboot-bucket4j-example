package com.oardic.springbootbucket4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A sample controller to test Bucket4j rate limiter.
 *
 * @author Okan ARDIC
 */
@RestController
public class SampleController {

	@GetMapping("/first")
	public String getMessageA() {
		return "first";
	}

	@GetMapping("/second")
	public String getMessageB() {
		return "second";
	}
}

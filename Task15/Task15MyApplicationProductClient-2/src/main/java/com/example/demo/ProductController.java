package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@GetMapping("product")
	public String msg() {
		return "I'm the Product Service.You can create a Product page and display";
	}
}

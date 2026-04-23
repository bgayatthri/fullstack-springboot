package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FactorialController {
	@Autowired
	private FactorialService service;
	
	@GetMapping("/")
	public String showForm() {
		return "factorial";
	}
	
	@PostMapping("/calculate")
	public String calculate(@RequestParam int number,Model model) {
		long result = service.calculateFactorial(number);
		model.addAttribute("number",number);
		model.addAttribute("result",result);
		return "factorial";
	}
}

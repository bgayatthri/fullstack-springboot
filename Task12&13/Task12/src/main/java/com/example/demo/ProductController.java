package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@RestController
@Validated
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/getProducts")
	public List<Product>getProducts(){
		return service.getProduct();
	}
	@GetMapping("/getProductByCost/{cost}")
	public Product getProductByCost( @PathVariable Double cost) {
		return service.getProductByCost(cost);
	}
	@GetMapping("/getProdut/{id}")
	public Product getProduct(@Valid@PathVariable int id) {
		return service.getProduct(id);
	}
	@GetMapping("/getProductByName/{name}")
	public Product getProductByName(@Valid@PathVariable String name) {
		return service.getProductByName(name);
	}
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> addDatap(@Valid @RequestBody Product product){
		service.addData(product);
		return ResponseEntity.ok(product);
	}
}

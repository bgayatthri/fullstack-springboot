package com.example.demo;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Fruit;


@RestController
@RequestMapping("/fruits")
public class FruitController {
	private final FruitRepository repo;
	
	public FruitController(FruitRepository repo) {
		this.repo=repo;
	}
	
	@PostMapping
	public Fruit addFruit(@RequestBody Fruit fruit){
		return repo.save(fruit);
	}
	@GetMapping
	public List<Fruit>getAllFruits(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Fruit getFruit(@PathVariable Long id){
		return repo.findById(id).orElse(null);
	}
	@PutMapping("/{id}")
	public Fruit updateFruit(@PathVariable Long id,@RequestBody Fruit fruit){
		Fruit existing =repo.findById(id).orElse(null);
		if(existing==null) return null;
		
		existing.setName(fruit.getName());
		existing.setQuantity(fruit.getQuantity());
		return repo.save(existing);

	}
	@DeleteMapping("/{id}")
	public String deleteFruit(@PathVariable Long id) {
		repo.deleteById(id);
		return "Deleted fruit id="+id;
		
	}
	@GetMapping("/count")
	public Long counFruits() {
		return repo.count();
	}
}

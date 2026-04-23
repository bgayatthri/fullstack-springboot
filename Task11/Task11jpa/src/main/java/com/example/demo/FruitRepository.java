package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Fruit;

public interface FruitRepository extends JpaRepository<Fruit,Long>{

	long count();

}

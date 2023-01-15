package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Dog;

public interface DogRepository extends JpaRepository<Dog,Integer> {
    
}

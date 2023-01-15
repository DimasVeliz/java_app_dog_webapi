package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.Dog;

public interface DogService {
    
    public List<Dog> GetAll();

    public Dog findById(int dogId);

    public Dog save(Dog theDog);

    public void deleteById(int dogId);
    
}

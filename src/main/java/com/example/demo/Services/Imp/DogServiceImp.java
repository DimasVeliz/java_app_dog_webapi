package com.example.demo.Services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Dog;
import com.example.demo.Repository.DogRepository;
import com.example.demo.Services.DogService;

@Service
public class DogServiceImp implements DogService {

    private DogRepository repository;
    
    @Autowired
    public DogServiceImp(DogRepository repository) {
        super();
        this.repository = repository;
    }


    @Override
    public List<Dog> GetAll()
    {
       var result = this.repository.findAll();

       return result;
    }

    @Override
    public Dog findById(int dogId) {
        var theDog = this.repository.findById(dogId);
        return theDog.get();
    }

    @Override
    public Dog save(Dog theDog) {
        Dog theDogInserted =this.repository.save(theDog);
        return theDogInserted;
        
    }

    @Override
    public void deleteById(int dogId) {
        this.repository.deleteById(dogId);        
    }
    
}

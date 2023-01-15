package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Dog;
import com.example.demo.Services.DogService;

@RestController
@RequestMapping("/api")
public class DogController {
    
    private DogService service;

    @Autowired
    public DogController(DogService dogService) {
        super();
        this.service = dogService;
    }

    @GetMapping("/dogs")
    public List<Dog> GetAll()
    {
        var response = service.GetAll();
        return response;
    }

    @GetMapping("/dogs/{dogId}")
	public Dog getdog(@PathVariable int dogId) {
		
		Dog theDog = service.findById(dogId);
		
		if (theDog == null) {
			throw new RuntimeException("dog id not found - " + dogId);
		}
		
		return theDog;
	}
	
	// add mapping for POST /dogs - add new dog
	
	@PostMapping("/dogs")
	public Dog adddog(@RequestBody Dog theDog) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		//theDog.setId(0);
		
		Dog theDogInserted = this.service.save(theDog);
		
		return theDogInserted;
	}
	
	// add mapping for PUT /dogs - update existing dog
	
	@PutMapping("/dogs")
	public Dog updatedog(@RequestBody Dog theDog) {
		
		service.save(theDog);
		
		return theDog;
	}
	
	// add mapping for DELETE /dogs/{dogId} - delete dog
	
	@DeleteMapping("/dogs/{dogId}")
	public String deleteDog(@PathVariable int dogId) {
		
		Dog tempdog = service.findById(dogId);
		
		// throw exception if null
		
		if (tempdog == null) {
			throw new RuntimeException("dog id not found - " + dogId);
		}
		
		service.deleteById(dogId);
		
		return "Deleted dog id - " + dogId;
	}   

}

package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name="dog")
public class Dog {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String Name;

    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        this.Name= name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int i) {
        this.id= i;
    }

    
}

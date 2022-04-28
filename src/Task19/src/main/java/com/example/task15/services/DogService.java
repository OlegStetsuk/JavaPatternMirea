package com.example.task15.services;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;

import java.util.List;

public interface DogService {
    Patient getPatientByDog(Long dogId);
    List<Dog> getFilteredDogs(String field);
    void addDog(Dog dogData);
}

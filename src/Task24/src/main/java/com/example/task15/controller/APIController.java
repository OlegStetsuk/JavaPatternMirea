package com.example.task15.controller;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import com.example.task15.services.DogServiceImpl;
import com.example.task15.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class APIController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @Autowired
    private DogServiceImpl dogServiceImpl;

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(patientServiceImpl.getPatients().get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public ResponseEntity postPatient(@RequestBody Patient patient) {
        try {
            patientServiceImpl.addPatient(patient);
            return ResponseEntity.ok("Patient successfully added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @RequestMapping(value = "/dog", method = RequestMethod.POST)
    public ResponseEntity postDog(@RequestBody Dog dog) {
        try {
            dogServiceImpl.addDog(dog);
            return ResponseEntity.ok("Dog successfully added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @RequestMapping(value = "/dog/{dogId}", method = RequestMethod.GET)
    public ResponseEntity getDogPatient(@PathVariable("dogId") Long dogId) {
        try {
            return ResponseEntity.ok(dogServiceImpl.getPatientByDog(dogId).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    @RequestMapping(value = "/dogs/filtered/{field}", method = RequestMethod.GET)
    public ResponseEntity getDogsFiltered(@PathVariable("field") String field) {
        try {
            return ResponseEntity.ok(dogServiceImpl.getFilteredDogs(field).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/patients/filtered/{field}", method = RequestMethod.GET)
    public ResponseEntity getPatientsFiltered(@PathVariable("field") String field) {
        try {
            return ResponseEntity.ok(patientServiceImpl.getFilteredPatients(field).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

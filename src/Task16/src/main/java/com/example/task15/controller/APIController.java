package com.example.task15.controller;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import com.example.task15.service.DogService;
import com.example.task15.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class APIController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DogService dogService;

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(patientService.getPatients());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public ResponseEntity postPatient(@RequestBody Patient patient) {
        try {
            patientService.addPatient(patient);
            return ResponseEntity.ok("Patient successfully added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @RequestMapping(value = "/dog", method = RequestMethod.POST)
    public ResponseEntity postDog(@RequestBody Dog dog) {
        try {
            dogService.addDog(dog);
            return ResponseEntity.ok("Dog successfully added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @RequestMapping(value = "/dog/{dogId}", method = RequestMethod.GET)
    public ResponseEntity getDogPatient(@PathVariable("dogId") Long dogId) {
        try {
            return ResponseEntity.ok(dogService.getPatientByDog(dogId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

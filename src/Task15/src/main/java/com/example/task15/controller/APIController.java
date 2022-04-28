package com.example.task15.controller;

import com.example.task15.entities.Patient;
import com.example.task15.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class APIController {

    private PatientService patientService;

    @Autowired
    public APIController(PatientService patientService) {
        this.patientService = patientService;
    }

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
}

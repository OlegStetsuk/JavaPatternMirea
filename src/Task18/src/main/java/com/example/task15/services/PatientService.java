package com.example.task15.services;

import com.example.task15.entities.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients();
    List<Patient> getFilteredPatients(String field);
    void addPatient(Patient userData);
}

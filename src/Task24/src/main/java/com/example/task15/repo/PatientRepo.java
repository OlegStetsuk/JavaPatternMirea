package com.example.task15.repo;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo  extends JpaRepository<Patient, Long> {
    List<Patient> findPatientByDogs(Dog dog);
}

package com.example.task15.services;

import com.example.task15.entities.Patient;
import com.example.task15.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Patient> patientCriteriaQuery;
    private Root<Patient> root;

    private final PatientRepo patientRepo;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();

        builder = session.getCriteriaBuilder();
        patientCriteriaQuery = builder.createQuery(Patient.class);
        root = patientCriteriaQuery.from(Patient.class);
    }

    public List<Patient> getPatients() {
        log.info("Find all patients");
        return patientRepo.findAll();
    }

    public List<Patient> getFilteredPatients(String field) {
        patientCriteriaQuery.select(root).orderBy(builder.asc(root.get(field)));
        Query patientQuery = session.createQuery(patientCriteriaQuery);
        log.info("Find filtered patients {}", field);
        return patientQuery.getResultList();
    }

    public void addPatient(Patient userData) {
        log.info("Save new patient");
        patientRepo.save(userData);
    }
}

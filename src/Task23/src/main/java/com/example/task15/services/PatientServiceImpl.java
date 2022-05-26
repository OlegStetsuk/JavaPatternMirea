package com.example.task15.services;

import com.example.task15.entities.Patient;
import com.example.task15.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Patient> patientCriteriaQuery;
    private Root<Patient> root;

    private final PatientRepo patientRepo;

    @Autowired
    private EmailSenderService senderService;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();

        builder = session.getCriteriaBuilder();
        patientCriteriaQuery = builder.createQuery(Patient.class);
        root = patientCriteriaQuery.from(Patient.class);
    }

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<List<Patient>> getPatients() {
        log.info("Find all patients");
        return CompletableFuture.completedFuture(patientRepo.findAll());
    }

    @Async
    public CompletableFuture<List<Patient>> getFilteredPatients(String field) {
        patientCriteriaQuery.select(root).orderBy(builder.asc(root.get(field)));
        Query patientQuery = session.createQuery(patientCriteriaQuery);
        log.info("Find filtered patients {}", field);
        return CompletableFuture.completedFuture(patientQuery.getResultList());
    }

    @Transactional
    @Async
    public void addPatient(Patient userData) {
        log.info("Save new patient");
        senderService.sendMail("test-email@gmail.com", "New patient was added", userData.getFirstName() + " " + userData.getFirstName());
        patientRepo.save(userData);
    }
}

package com.example.task15.service;

import com.example.task15.entities.Patient;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PatientService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Patient> patientCriteriaQuery;
    private Root<Patient> root;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();

        builder = session.getCriteriaBuilder();
        patientCriteriaQuery = builder.createQuery(Patient.class);
        root = patientCriteriaQuery.from(Patient.class);
    }

    public List<Patient> getPatients() {
        return session.createQuery("select u from Patient u", Patient.class).getResultList();
    }

    public List<Patient> getFilteredPatients(String field) {
        patientCriteriaQuery.select(root).orderBy(builder.asc(root.get(field)));
        Query patientQuery = session.createQuery(patientCriteriaQuery);
        return patientQuery.getResultList();
    }

    public void addPatient(Patient userData) {
        Patient user = new Patient();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        var transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
    }
}

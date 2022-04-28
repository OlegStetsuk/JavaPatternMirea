package com.example.task15.service;

import com.example.task15.entities.Patient;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PatientService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<Patient> getPatients() {
        return session.createQuery("select u from Patient u", Patient.class).getResultList();
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

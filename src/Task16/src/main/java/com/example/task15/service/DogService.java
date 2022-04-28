package com.example.task15.service;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class DogService {
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    private PatientService patientService;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public Patient getPatientByDog(Long dogId) {
        return session.createQuery("from Dog where id = :id", Dog.class).setParameter("id", dogId).getSingleResult().getPatient();
    }

    public void addDog(Dog dogData) {
        Dog dog = new Dog(dogData.getName(), dogData.getBreed());
        dog.setPatient(patientService.getPatients().get(0));
        var transaction = session.beginTransaction();
        session.saveOrUpdate(dog);
        transaction.commit();
    }
}

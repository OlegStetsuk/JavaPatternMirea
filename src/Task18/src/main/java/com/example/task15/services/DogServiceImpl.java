package com.example.task15.services;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import com.example.task15.repo.DogRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Dog> dogCriteriaQuery;
    private Root<Dog> root;
    private final DogRepo dogRepo;

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        dogCriteriaQuery = builder.createQuery(Dog.class);
        root = dogCriteriaQuery.from(Dog.class);
    }

    public Patient getPatientByDog(Long dogId) {
        return session.createQuery("from Dog where id = :id", Dog.class).setParameter("id", dogId).getSingleResult().getPatient();
    }

    public List<Dog> getFilteredDogs(String field) {
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(field)));
        Query dogQuery = session.createQuery(dogCriteriaQuery);
        return dogQuery.getResultList();
    }

    public void addDog(Dog dogData) {
        dogRepo.save(dogData);
    }
}

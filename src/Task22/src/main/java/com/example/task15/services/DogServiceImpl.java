package com.example.task15.services;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import com.example.task15.repo.DogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogServiceImpl {
    private SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Dog> dogCriteriaQuery;
    private Root<Dog> root;

    private DogRepo dogRepo;

    @Autowired
    private EmailSenderService senderService;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();

        builder = session.getCriteriaBuilder();
        dogCriteriaQuery = builder.createQuery(Dog.class);
        root = dogCriteriaQuery.from(Dog.class);
    }

    public DogServiceImpl(SessionFactory sessionFactory, DogRepo dogRepo) {
        this.sessionFactory = sessionFactory;
        this.dogRepo = dogRepo;
    }

    @Autowired
    public DogServiceImpl(DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    @Transactional(readOnly = true)
    @Async
        public CompletableFuture<Patient> getPatientByDog(Long dogId) {
        log.info("Find patient by dog");
        return CompletableFuture.completedFuture(session.createQuery("from Dog where id = :id", Dog.class).setParameter("id", dogId).getSingleResult().getPatient());
    }

    @Transactional(readOnly = true)
    @Async
    public CompletableFuture<List<Dog>> getFilteredDogs(String field) {
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(field)));
        Query dogQuery = session.createQuery(dogCriteriaQuery);
        log.info("Find filtered dogs {}", field);
        return CompletableFuture.completedFuture(dogQuery.getResultList());
    }

    @Transactional
    @Async
    public void addDog(Dog dogData) {
        log.info("Save new dog");
        senderService.sendMail("test-email@gmail.com",
                           "New dog was added",
                            dogData.getName() + " " + dogData.getBreed());
        dogRepo.save(dogData);
    }
}

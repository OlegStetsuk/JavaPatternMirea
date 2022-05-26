package com.example.task15;

import com.example.task15.entities.Dog;
import com.example.task15.repo.DogRepo;
import com.example.task15.services.DogServiceImpl;
import com.example.task15.services.EmailSenderService;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {
    @Mock
    private DogRepo dogRepo;

    @Mock
    private SessionFactory sessionFactory;

    @Captor
    ArgumentCaptor<Dog> captor;

    @Test
    public void addDog() {
        Dog dog1 = new Dog();
        dog1.setName("Dog1");
        dog1.setBreed("Breed1");

        DogServiceImpl dogService = new DogServiceImpl(sessionFactory, dogRepo);
        dogService.addDog(dog1);

        Mockito.verify(dogRepo).saveAndFlush(captor.capture());
        Dog captured = captor.getValue();
        Assertions.assertEquals("Dog1", captured.getName());
    }

    @Test
    public void getFilteredDogs() {

    }
}

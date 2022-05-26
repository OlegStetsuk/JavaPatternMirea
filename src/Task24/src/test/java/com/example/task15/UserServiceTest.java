package com.example.task15;

import com.example.task15.entities.Role;
import com.example.task15.entities.UserEntity;
import com.example.task15.repo.RoleRepo;
import com.example.task15.repo.UserRepo;
import com.example.task15.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepo userRepo;

    @Mock
    private RoleRepo roleRepo;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Captor
    ArgumentCaptor<UserEntity> captor;

    @Test
    void getUsers() {
        UserEntity user1 = new UserEntity();
        user1.setUsername("User1");
        user1.setPassword("pass");
        user1.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        Mockito.when(userRepo.findAll()).thenReturn(List.of(user1));
        UserService userService = new UserService(userRepo, roleRepo, bCryptPasswordEncoder);
        Assertions.assertEquals(1, userService.allUsers().size());
        Assertions.assertEquals("User1", userService.allUsers().get(0).getUsername());
    }

    @Test
    void saveOrUpdate() {
        UserEntity user1 = new UserEntity();
        user1.setUsername("User1");
        user1.setPassword("pass");
        UserService userService = new UserService(userRepo, roleRepo, bCryptPasswordEncoder);
        userService.saveUser(user1);
        Mockito.verify(userRepo).save(captor.capture());
        UserEntity captured = captor.getValue();
        Assertions.assertEquals("User1", captured.getUsername());
    }
}

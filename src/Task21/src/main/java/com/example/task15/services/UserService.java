package com.example.task15.services;

import
        com.example.task15.entities.Role;
import com.example.task15.entities.UserEntity;
import com.example.task15.repo.RoleRepo;
import com.example.task15.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public UserEntity findUserById(Long id) {
        Optional<UserEntity> user = userRepo.findById(id);
        return user.orElse(null);
    }

    public List<UserEntity> allUsers() {
        return userRepo.findAll();
    }

    public boolean saveUser(UserEntity userEntity) {
        UserEntity userFromDB = userRepo.findByUsername(userEntity.getUsername());
        if (userFromDB != null) {
            return false;
        }

        Role userRole = roleRepo.save(new Role(1L, "ROLE_USER"));
        userEntity.setRoles(Collections.singleton(userRole));
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userRepo.save(userEntity);
        return true;
    }
}

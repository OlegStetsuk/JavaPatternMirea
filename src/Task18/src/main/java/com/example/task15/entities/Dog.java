package com.example.task15.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "dogs")
@Entity
@Getter
@Setter
public class Dog {
    @Id
    @SequenceGenerator(name = "d_seq", sequenceName = "dogs_sequence", allocationSize = 1)
    @GeneratedValue(generator = "d_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String breed;
    @ManyToOne
    @JsonIgnore
    public Patient patient;

    public Dog() {
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

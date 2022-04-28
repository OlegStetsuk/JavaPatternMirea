package com.example.task14;

import javax.validation.constraints.NotNull;

public class Doctor {
    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public String position;

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

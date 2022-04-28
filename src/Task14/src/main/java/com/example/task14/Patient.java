package com.example.task14;

import javax.validation.constraints.NotNull;

public class Patient {

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }
}

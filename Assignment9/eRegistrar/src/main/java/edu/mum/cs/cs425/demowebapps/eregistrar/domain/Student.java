package edu.mum.cs.cs425.demowebapps.eregistrar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;



@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long studentId;

    @NotNull(message = "This field is required")
    String studentNumber;

    @NotNull(message = "This field is required")
    String firstName;

    String middleName;

    @NotNull(message = "This field is required")
    String lastName;

    double cgpa;

    @NotNull(message = "This field is required")
    LocalDate enrollmentDate;

    @NotNull(message = "This field is required")
    String isInternational;

}

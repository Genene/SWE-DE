package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Nonnull
    private String studentNumber;

    @Nonnull
    private String firstName;

    private String middleName;

    @Nonnull
    private String lastName;

    private Float cgpa;

    private LocalDate dateOfEnrollment;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Transcript> transcripts = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_classroom")
    private Classroom classroom;

    public Student() {}

    public Student(String studentNumber, String firstName, String middleName, String lastName, Float cgpa,
                   LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, Float cgpa,
                   LocalDate dateOfEnrollment, List<Transcript> transcripts) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcripts = transcripts;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, Float cgpa,
                   LocalDate dateOfEnrollment, List<Transcript> transcripts, Classroom classroom) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcripts = transcripts;
        this.classroom = classroom;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public void addTranscript(Transcript transcript) {
        this.transcripts.add(transcript);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return String.format(
                "Student {studentId=%s, studentNumber=%s, firstName=%s, middleName=%s, lastName=%s, cgpa=%s, dateOfEnrollment=%s}",
                studentId, studentNumber, firstName, middleName, lastName, cgpa, dateOfEnrollment);
    }

}

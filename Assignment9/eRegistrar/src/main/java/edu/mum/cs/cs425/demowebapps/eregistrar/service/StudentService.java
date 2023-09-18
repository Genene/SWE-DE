package edu.mum.cs.cs425.demowebapps.eregistrar.service;

import edu.mum.cs.cs425.demowebapps.eregistrar.domain.Student;

public interface StudentService {
    Student saveStudent(Student student);
    void deleteStudent(Long studentId);
    Student getStudentById(Long studentId);
    Iterable<Student> getAllStudents();
}

package edu.mum.cs.cs425.demowebapps.eregistrar.service.Impl;

import edu.mum.cs.cs425.demowebapps.eregistrar.domain.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public Student getStudentById(Long studentId) {
        return null;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

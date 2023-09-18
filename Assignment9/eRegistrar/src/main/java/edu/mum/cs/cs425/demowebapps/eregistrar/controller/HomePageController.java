package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import edu.mum.cs.cs425.demowebapps.eregistrar.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    private StudentService studentService;

    @GetMapping(value = {"/","/eregistrar/home","/eregistrar/home/index"})
    public String displayHomePage(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "home/index";
    }

    @PostMapping(value = {"student/add"})
    public String addNewStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/eregistrar/home/index";
    }

    @GetMapping(value = {"student/new"})
    public String displayNewStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "home/student/new";
    }

    @GetMapping(value = {"/eregistrar/student/edit"})
    public String displayEditStudentForm(){
        return "student/edit";
    }

    @GetMapping(value = {"/eregistrar/student/delete"})
    public String deleteStudent(){
        return "student/delete";
    }




    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

}

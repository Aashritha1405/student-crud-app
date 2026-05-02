package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/addStudent")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students";

    }
@GetMapping("/editStudent/{id}")
public String showUpdateForm(@PathVariable Long id, Model model) {

    Student student = service.getStudentById(id);

    System.out.println("DEBUG STUDENT: " + student); // 🔍 check this

    if (student == null) {
        System.out.println("Student not found!");
        return "redirect:/students";
    }

    model.addAttribute("student", student);
    return "updateStudent";
}

}
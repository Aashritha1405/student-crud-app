package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void saveStudent(Student student) {
        repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null); // ✅ FIXED
    }
}
package net.yeah.boot.controller;

import net.yeah.boot.pojo.Student;
import net.yeah.boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "student/data")
    public List<Student> get () {
        return studentRepository.findAll();
    }

    @PostMapping(value = "student/add")
    public Student add (@RequestBody Student student) {
        Student result = studentRepository.save(student);

        return  result;
    }

    @PutMapping(value = "student/update/{id}")
    public Student update (@RequestBody Student student, @PathVariable(name = "id", required = true) Integer id) {
        student.setId(id);
        Student result = studentRepository.save(student);

        return result;
    }

    @DeleteMapping(value = "student/delete/{id}")
    public void delete (@PathVariable(name = "id", required = true) Integer id) {
        studentRepository.delete(id);
    }
}

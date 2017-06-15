package net.yeah.boot.controller;

import net.yeah.boot.exception.NdException;
import net.yeah.boot.pojo.People;
import net.yeah.boot.pojo.Result;
import net.yeah.boot.pojo.Student;
import net.yeah.boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ValidateController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value = "validate/param")
    public void validate(@Valid @RequestBody People people, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
    }

    @PutMapping(value = "validate/student/update/{id}")
    public Result<Student> update (@Validated @RequestBody Student student, @PathVariable(name = "id", required = true) Integer id, BindingResult bindingResult) {
        Result<Student> results = new Result<Student>();

        results.setCode(0);
        results.setMessage("成功");

        student.setId(id);
        Student result = studentRepository.save(student);
        results.setData(result);


        return results;
    }

    @PutMapping(value = "validate/exception/{id}")
    public String exception (@PathVariable(value = "id", required = true) Integer id) {
        if (id < 10) {
            throw new NdException(10, "My Exception");
        }

        return "OJ";
    }
}

package com.mysqlLayers.demo.Controller;


import com.mysqlLayers.demo.Entity.Student;
import com.mysqlLayers.demo.ServiceBusinessLogic.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/remove/{id}")
    public String removeStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudent(id);
        return deleted ? "Deleted" : "Not Found";
    }

    @PutMapping("/update/{id}")
    public boolean updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
}

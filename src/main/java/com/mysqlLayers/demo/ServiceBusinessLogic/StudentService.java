package com.mysqlLayers.demo.ServiceBusinessLogic;

import com.mysqlLayers.demo.Entity.Student;
import com.mysqlLayers.demo.Repository.StudentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepositoryJPA studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a student by id
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Delete student by id
    public boolean deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            studentRepository.delete(student);
            return true;
        }
        return false;
    }

    // Update student info
    public boolean updateStudent(int id, Student newData) {
        Student existingStudent = getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(newData.getName());
            existingStudent.setMark(newData.getMark());
            studentRepository.save(existingStudent);
            return true;
        }
        return false;
    }
}

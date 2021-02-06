package com.student.enrollmentapi.rest;
import com.student.enrollmentapi.entity.Student;
import com.student.enrollmentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.getStudents();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/studentsByRoll")
    public List<Student> findAllByRoll(@RequestBody Student student) {
        return studentService.getStudentsbyRoll(student.getRoll());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/studentsByDept/{theDept}")
    public List<Student> findAllByDepartment(@PathVariable String theDept) {
        return studentService.getStudentsbyDept(theDept);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/student/{theId}")
    public Student findById(@PathVariable Integer theId) {
        return studentService.getStudent(theId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteStudent/{theId}")
    public String deleteStudent(@PathVariable Integer theId) {
        studentService.deleteStudent(theId);
        return "Student Deleted successfully. Id= " + theId;
    }

}

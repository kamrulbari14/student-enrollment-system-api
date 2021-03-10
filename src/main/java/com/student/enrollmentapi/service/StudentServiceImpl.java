package com.student.enrollmentapi.service;
import com.student.enrollmentapi.entity.Student;
import com.student.enrollmentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "session"));
    }

    @Override
    public void saveStudent(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public List<Student> getStudentsbyRoll(Integer theRoll) {
        return studentRepository.findAllByRoll(theRoll);
    }

    @Override
    public List<Student> getStudentsbyDept(String theDept) {
        return studentRepository.findAllBydepartment(theDept);
    }

    @Override
    public Student getStudent(Integer theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        } else {
            throw new RuntimeException("Employee not found in id" + theId);
        }
        return theStudent;
    }

    @Override
    public void deleteStudent(Integer theId) {

        studentRepository.deleteById(theId);
    }
}

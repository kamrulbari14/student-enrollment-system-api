package com.student.enrollmentapi.repository;

import com.student.enrollmentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM STUDENT u WHERE u.department = :department",
            nativeQuery = true)
    List<Student> findAllBydepartment(@Param("department") String theDept);

    @Query(value = "SELECT * FROM STUDENT u WHERE u.roll = :roll",
            nativeQuery = true)
    List<Student> findAllByRoll(@Param("roll") Integer theRoll);
}

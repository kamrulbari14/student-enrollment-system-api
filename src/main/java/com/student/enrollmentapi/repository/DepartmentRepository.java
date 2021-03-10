package com.student.enrollmentapi.repository;

import com.student.enrollmentapi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

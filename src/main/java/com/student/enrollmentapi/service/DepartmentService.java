package com.student.enrollmentapi.service;

import com.student.enrollmentapi.entity.Department;

import java.util.List;

public interface DepartmentService {


    public List<Department> getDepartment();

    public void saveDepartment(Department department);
}

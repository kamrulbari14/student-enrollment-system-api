package com.student.enrollmentapi.service;

import com.student.enrollmentapi.entity.Department;
import com.student.enrollmentapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

}

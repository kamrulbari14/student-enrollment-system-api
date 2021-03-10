package com.student.enrollmentapi.service;

import com.student.enrollmentapi.entity.Admin;
import com.student.enrollmentapi.entity.AdminName;
import com.student.enrollmentapi.repository.AdminNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminNameServiceImpl implements AdminNameService {

    private AdminNameRepository adminNameRepository;

    @Autowired
    public AdminNameServiceImpl(AdminNameRepository adminNameRepository) {
        this.adminNameRepository = adminNameRepository;
    }

    @Override
    public AdminName getAdminName(String email) {
        return adminNameRepository.findByEmail(email);
    }

    @Override
    public void saveAdminName(AdminName adminName) {
        adminNameRepository.save(adminName);
    }

}

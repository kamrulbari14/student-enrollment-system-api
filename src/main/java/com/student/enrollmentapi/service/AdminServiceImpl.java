package com.student.enrollmentapi.service;

import com.student.enrollmentapi.entity.Admin;
import com.student.enrollmentapi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean getAdmin(String email) {

        Optional<Admin> result = Optional.ofNullable(adminRepository.findByEmail(email));
        return result.isPresent();
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}

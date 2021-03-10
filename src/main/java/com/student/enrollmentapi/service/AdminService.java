package com.student.enrollmentapi.service;

import com.student.enrollmentapi.entity.Admin;

public interface AdminService {

    public boolean getAdmin(String email);

    public void saveAdmin(Admin admin);
}

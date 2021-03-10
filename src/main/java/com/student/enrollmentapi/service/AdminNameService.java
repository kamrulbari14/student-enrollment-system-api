package com.student.enrollmentapi.service;

import com.student.enrollmentapi.entity.AdminName;

public interface AdminNameService {

    public AdminName getAdminName(String email);

    public void saveAdminName(AdminName adminName);
}

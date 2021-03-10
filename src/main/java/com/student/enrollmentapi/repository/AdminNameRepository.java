package com.student.enrollmentapi.repository;

import com.student.enrollmentapi.entity.AdminName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminNameRepository extends JpaRepository<AdminName, Integer> {
    AdminName findByEmail(@Param("email") String email);
}

package com.sarasavi.lib_auth_service.repository;

import com.sarasavi.lib_auth_service.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}

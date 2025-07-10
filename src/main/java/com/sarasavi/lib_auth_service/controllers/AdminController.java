package com.sarasavi.lib_auth_service.controllers;

import com.sarasavi.lib_auth_service.dto.AdminDTO;
import com.sarasavi.lib_auth_service.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/admins/auth")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // admin authentication methods will be added here
    @PostMapping(path = "/login")
    public boolean login(@RequestBody AdminDTO adminDTO) {
        // Call the service to authenticate the admin
        return adminService.loginAdmin(adminDTO.getEmail(), adminDTO.getPassword());
    }
}

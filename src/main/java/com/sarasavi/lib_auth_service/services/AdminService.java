package com.sarasavi.lib_auth_service.services;

import com.sarasavi.lib_auth_service.dto.AdminDTO;
import com.sarasavi.lib_auth_service.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // admin login via email and password
    public boolean loginAdmin(String email, String password){
        //send Email to the http://localhost:8080/api/v1/admins/by-email?john.doe@example.com
        //and get the admin username and password according to the email

        try{

            AdminDTO admin = restTemplate.getForObject(
                "http://localhost:8080/api/v1/admins/by-email?email=" + email,
                AdminDTO.class);

            if (admin == null) {
                System.out.println("Admin not found with email: " + email);
                return false;
            }

            String storedPassword = admin.getPassword();

            if (passwordEncoder.matches(password, storedPassword)) {
                // Login successful
                System.out.println("Login successful for admin: " + admin.getName());
                return true;
            } else {
                // Password does not match
                System.out.println("Invalid password for admin: " + email);
                return false;
            }

        }
        catch (Exception e){
            System.out.println("Error occurred while logging in: " + e.getMessage());
            return false;
        }

    }
}

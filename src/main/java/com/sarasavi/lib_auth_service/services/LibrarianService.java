package com.sarasavi.lib_auth_service.services;

import com.sarasavi.lib_auth_service.dto.LibrarianDTO;
import com.sarasavi.lib_auth_service.repository.LibrarianRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // librarian login via email and password
    public boolean loginLibrarian(String email, String password) {
        try {
            LibrarianDTO librarian = restTemplate.getForObject("http://localhost:8080/librarians/email/" + email, LibrarianDTO.class);
            if (librarian == null) {
                System.out.println("Librarian not found with email: " + email);
                return false;
            }

            String storedPassword = librarian.getPassword();
            if (passwordEncoder.matches(password, storedPassword)) {
                System.out.println("Librarian logged in successfully: " + email);
                return true;
            } else {
                System.out.println("Invalid password for librarian: " + email);
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error occurred while logging in: " + e.getMessage());
            return false;
        }
    }
}

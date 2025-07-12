package com.sarasavi.lib_auth_service.services;

import com.sarasavi.lib_auth_service.dto.LibrarianDTO;
import com.sarasavi.lib_auth_service.repository.LibrarianRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LibrarianService {

    private static final Logger logger = LoggerFactory.getLogger(LibrarianService.class);

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
            String url = UriComponentsBuilder
                    .fromHttpUrl("http://localhost:8080/api/v1/librarians/by-email")
                    .queryParam("email", email)
                    .toUriString();

            LibrarianDTO librarian = restTemplate.getForObject(url, LibrarianDTO.class);

            if (librarian == null || librarian.getPassword() == null) {
                logger.warn("Librarian not found or password is null for email: {}", email);
                return false;
            }

            String storedPassword = librarian.getPassword();

            if (passwordEncoder.matches(password, storedPassword)) {
                logger.info("Login successful for librarian: {}", email);
                return true;
            } else {
                logger.warn("Invalid password for librarian: {}", email);
                return false;
            }

        } catch (Exception e) {
            logger.error("Error occurred while logging in librarian with email {}: {}", email, e.getMessage());
            return false;
        }
    }
}

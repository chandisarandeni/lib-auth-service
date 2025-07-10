package com.sarasavi.lib_auth_service.controllers;


import com.sarasavi.lib_auth_service.dto.LibrarianDTO;
import com.sarasavi.lib_auth_service.entity.Librarian;
import com.sarasavi.lib_auth_service.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/librarians/auth")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    // librarian authentication methods will be added here
    @PostMapping(path = "/login")
    public boolean login(@RequestBody LibrarianDTO librarianDTO) {
        // Call the service method to authenticate the librarian
        return librarianService.loginLibrarian(librarianDTO.getEmail(), librarianDTO.getPassword());
    }

}

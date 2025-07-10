package com.sarasavi.lib_auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianDTO {
    private int librarianId;
    private String name;
    private String nic;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
}

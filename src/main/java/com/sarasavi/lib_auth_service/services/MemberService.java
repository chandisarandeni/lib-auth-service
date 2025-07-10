package com.sarasavi.lib_auth_service.services;

import com.sarasavi.lib_auth_service.dto.MemberDTO;
import com.sarasavi.lib_auth_service.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // member login via email and password
    public boolean loginMember(String email, String password) {
        // send email to the http://localhost:8080/api/v1/members/by-email?email=john.doe@example.com
        // and ge the username and the password according to the email

        try {
            MemberDTO member = restTemplate.getForObject("http://localhost:8080/api/v1/members/by-email?email=" + email, MemberDTO.class);
            if (member == null) {
                System.out.println("Member not found with email: " + email);
                return false; // member not found
            }
            String storedPassword = member.getPassword();

            if (passwordEncoder.matches(password, storedPassword)) {
                // Password matches, login successful
                System.out.println("Login successful for member: " + email);
                return true;
            } else {
                // Password does not match
                System.out.println("Invalid password for member: " + email);
                return false;
            }

        } catch (Exception e) {
            // handle exception
            System.out.println("Error occurred while logging in: " + e.getMessage());
            return false;
        }
    }
}

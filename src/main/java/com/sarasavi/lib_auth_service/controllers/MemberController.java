package com.sarasavi.lib_auth_service.controllers;

import com.sarasavi.lib_auth_service.dto.MemberDTO;
import com.sarasavi.lib_auth_service.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/members/auth")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // member login via email and password
    // This method is not implemented here, but it would typically handle login requests.
    @PostMapping(path = "/login")
    public boolean loginMember(@RequestBody MemberDTO memberDTO) {
        return memberService.loginMember(memberDTO.getEmail(), memberDTO.getPassword());
    }

}

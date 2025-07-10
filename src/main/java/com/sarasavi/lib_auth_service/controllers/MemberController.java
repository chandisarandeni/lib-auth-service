package com.sarasavi.lib_auth_service.controllers;

import com.sarasavi.lib_auth_service.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

}

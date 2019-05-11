package com.sapphireDevils.conferenceManagementSystem.Controller;


import com.sapphireDevils.conferenceManagementSystem.Utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private AuthUtils authUtils;

    @GetMapping("/role")
    public String getRoles() {

//        authUtils.testSecurity();
        return "rest";
    }

    @GetMapping("/role2")
    public String getRole2s() {
//        authUtils.testSecurity();
        return authUtils.getUser().getRoles().iterator().next().getName();
    }


    @Secured("ROLE_USER")
    @GetMapping
    public String showRegistrationForm() {
        return "test";
    }

    @RolesAllowed("ROLE_USER")
    @GetMapping("/test2")
    public String showRegistrationForm2() {
        return "test2";
    }

    @PreAuthorize("hasAuthority('READ_ABSTRACT')") // DOAR ASTA MERGE
    @GetMapping("/test3")
    public String showRegistrationForm3() {
        return "test2";
    }

    @PreAuthorize("hasRole('READ_ABSTRACT')")
    @GetMapping("/test4")
    public String showRegistrationForm4() {
        return "test2";
    }

    @GetMapping("/test5")
    @PreAuthorize("hasRole('ROLE_ROLE_USER')")
    public String showRegistrationForm5() {
        return "test2";
    }

    @GetMapping("/test6")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showRegistrationForm6() {
        return "test2";
    }

    @GetMapping("/test7")
    @PreAuthorize("hasRole('USER')")
    public String showRegistrationForm7() {
        return "test2";
    }


}


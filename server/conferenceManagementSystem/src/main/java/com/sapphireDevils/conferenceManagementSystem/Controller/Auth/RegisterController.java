package com.sapphireDevils.conferenceManagementSystem.Controller.Auth;

import com.sapphireDevils.conferenceManagementSystem.Controller.Response;
import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserRegisterDto;
import com.sapphireDevils.conferenceManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    //TESTing
    @GetMapping
    public String showRegistrationForm(@RequestBody UserRegisterDto registerDto) {
        return "registration";
    }

    @PostMapping
    public Response register(@RequestBody UserRegisterDto registerDto) {
        try {
            return new Response(userService.registerNewUserAccount(registerDto));
        } catch (Exception e) {
            return Response.getErrorResponse(e.getMessage());
        }
    }

    @GetMapping("test")
    public Date test() {
        return new Date();
    }

}

package com.sapphireDevils.conferenceManagementSystem.Controller.Auth;

import com.sapphireDevils.conferenceManagementSystem.Controller.Response;
import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserRegisterDto;
import com.sapphireDevils.conferenceManagementSystem.Repository.UserRepository;
import com.sapphireDevils.conferenceManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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
            return Response.getErrorResponse();
        }
//        if( userRepository.findByEmail(register.getUser().getEmail()) != null )
//            return null; // TODO: return error
//        User user = userRepository.save(register.getUser());
//
//        if(register.getDonor() != null) {
//            register.getDonor().setUser(user);
//            register.getUser().setEntityType(EntityType.DONOR);
//            return new Response(donorRepository.save(register.getDonor()));
//        }
//
//        if(register.getOrganization() != null) {
//            System.out.println("here org");
//            register.getOrganization().setUser(user);
//            register.getUser().setEntityType(EntityType.ORGANIZATION_ADMIN);
//            return new Response(organizationRepository.save(register.getOrganization()));
//        }
//
//        return null;
    }

}

package com.sapphireDevils.conferenceManagementSystem.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("/connection")
public class ConnectionController {
    public String checkConnection(){
        return "{\"check\":true}";
    }
}

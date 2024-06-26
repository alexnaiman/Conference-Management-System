package com.sapphireDevils.conferenceManagementSystem.Utils;


import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthUtils {

    public User getUser() {
        return ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

    public boolean isOfUser(int userId) {
        return getUser().getId() == userId;
    }

}

package com.sapphireDevils.conferenceManagementSystem.Utils;


import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.UserPrincipal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthUtils {

    public User getUser() {
        return ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

    @Secured("ROLE_USER")
    public void testSecurity() {
        System.out.println("test security");
    }

//    public Organization getOrganization() {
//        return organizationRepository.findOne(
//                new BooleanBuilder(QOrganization.organization.user.id.eq(getUser().getId()))
//        );
//    }
//
//    public Donor getDonor() {
//        return donorRepository.findOne(
//                new BooleanBuilder(QDonor.donor.user.id.eq(getUser().getId()))
//        );
//    }

    public boolean isOfUser(int userId) {
        return getUser().getId() == userId;
    }

}

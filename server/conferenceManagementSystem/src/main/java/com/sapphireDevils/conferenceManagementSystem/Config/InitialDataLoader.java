package com.sapphireDevils.conferenceManagementSystem.Config;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.EntityType;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.Privilege;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.Role;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.PrivilegeRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.RoleRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
//        Privilege readPrivilege
//                = createPrivilegeIfNotFound("READ_PRIVILEGE");
//        Privilege writePrivilege
//                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
////        "READ_ABSTRACT" "WRITE_ABSTRACT"
//        List<Privilege> adminPrivileges = Arrays.asList(
//                readPrivilege, writePrivilege);
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_USER", Collections.singletonList(readPrivilege));
        createRoleIfNotFound(EntityType.AUTHOR.name(), EntityType.AUTHOR.getPrivileges());
        createRoleIfNotFound(EntityType.STEERING_COMMITTEE.name(), EntityType.STEERING_COMMITTEE.getPrivileges());
//        createRoleIfNotFound(EntityType.REVIEWER.name(), EntityType.REVIEWER.getPrivileges());

//        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//        User user = new User();
//        user.setPassword(passwordEncoder.encode("test"));
//        user.setEmail("test@test.com");
//        user.setRoles(Collections.singletonList(adminRole));
//        user.setEntityType(EntityType.AUTHOR);
//        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    void createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
//        return privilege;
    }

    @Transactional
    void createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {
        privileges.forEach((item) -> createPrivilegeIfNotFound(item.getName()));
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
//        return role;
    }
}
package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByName(String name);

    @Override
    void delete(Role role);

}
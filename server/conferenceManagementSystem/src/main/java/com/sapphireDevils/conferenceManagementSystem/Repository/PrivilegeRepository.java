package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    public Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
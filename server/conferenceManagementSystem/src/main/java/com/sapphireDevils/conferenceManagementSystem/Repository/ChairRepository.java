package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Chair;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.BaseUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends BaseUserRepository<Chair> {
}

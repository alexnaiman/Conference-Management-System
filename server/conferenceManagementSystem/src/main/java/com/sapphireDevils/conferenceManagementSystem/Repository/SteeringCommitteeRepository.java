package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.SteeringCommittee;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.BaseUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteeringCommitteeRepository extends BaseUserRepository<SteeringCommittee> {
}

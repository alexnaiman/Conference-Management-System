package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Reviewer;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.BaseUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends BaseUserRepository<Reviewer> {
}

package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.BaseUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseUserRepository<Author> {
}

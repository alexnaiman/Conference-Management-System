package com.sapphireDevils.conferenceManagementSystem.Repository.Auth;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

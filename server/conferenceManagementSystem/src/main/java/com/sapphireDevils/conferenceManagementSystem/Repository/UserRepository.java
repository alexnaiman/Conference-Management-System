package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

//@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

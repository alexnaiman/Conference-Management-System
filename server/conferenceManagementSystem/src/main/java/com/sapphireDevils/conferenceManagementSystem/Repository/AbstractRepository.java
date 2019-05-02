package com.sapphireDevils.conferenceManagementSystem.Repository;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractRepository extends BaseRepository<User> {
}
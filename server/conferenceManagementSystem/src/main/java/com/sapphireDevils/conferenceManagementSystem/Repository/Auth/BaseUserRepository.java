package com.sapphireDevils.conferenceManagementSystem.Repository.Auth;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.BaseUser;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseUserRepository<T extends BaseUser> extends BaseRepository<T> {
}

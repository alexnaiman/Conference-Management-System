package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Repository.AuthorRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<Author> {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BaseRepository<Author> getRepository() {
        return authorRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return UserAllDataDto.class;
    }
}

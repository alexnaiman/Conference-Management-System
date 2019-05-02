package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserRegisterDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.EntityType;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Repository.AuthorRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.RoleRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ModelMapper modelMapper;

    public UserService() {
        this.modelMapper = new ModelMapper();
    }


    @Transactional
    public User registerNewUserAccount(UserRegisterDto accountDto)
            throws Exception {

        if (emailExists(accountDto.getEmail())) {
            throw new Exception("There is an account with that email address:" + accountDto.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(accountDto.getPassword());
        switch (EntityType.valueOf(accountDto.getEntityType())) {
            case AUTHOR:
                Author author = modelMapper.map(accountDto, Author.class);
                author.getUser().setPassword(encodedPassword);
                author.getUser().setRoles(Collections.singletonList(roleRepository.findByName("ROLE_USER")));
                System.out.println(author.getUser());

                return authorRepository.save(author).getUser();
        }
        return null;
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


}

package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserRegisterDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.EntityType;
import com.sapphireDevils.conferenceManagementSystem.Repository.AuthorRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.RoleRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public UserAllDataDto registerNewUserAccount(UserRegisterDto accountDto)
            throws Exception {

        if (emailExists(accountDto.getEmail())) {
            throw new Exception("There is an account with that email address:" + accountDto.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(accountDto.getPassword());
        return EntityType.valueOf(accountDto.getEntityType()).create(modelMapper, encodedPassword, accountDto, roleRepository, authorRepository);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


}

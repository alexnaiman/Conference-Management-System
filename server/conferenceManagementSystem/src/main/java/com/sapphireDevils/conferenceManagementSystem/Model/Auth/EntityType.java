package com.sapphireDevils.conferenceManagementSystem.Model.Auth;

import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserRegisterDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Model.SteeringCommittee;
import com.sapphireDevils.conferenceManagementSystem.Repository.AuthorRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.Auth.RoleRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Here we have an enum for creating and mananging our entities type
 */
public enum EntityType {
    AUTHOR {
        @Override
        public List<Privilege> getPrivileges() {
            return Arrays.asList(new Privilege("READ_ABSTRACT"), new Privilege("WRITE_ABSTRACT"));
        }

        @Override
        public UserAllDataDto create(ModelMapper modelMapper, String encodedPassword, UserRegisterDto accountDto, RoleRepository roleRepository, BaseRepository authorRepository) {
            Author author = modelMapper.map(accountDto, Author.class);
            author.getUser().setPassword(encodedPassword);
            author.getUser().setRoles(Collections.singletonList(roleRepository.findByName(name())));
            UserAllDataDto allData = modelMapper.map(authorRepository.save(author).getUser(), UserAllDataDto.class);
            allData.setEntityType(EntityType.AUTHOR);
            return allData;
        }
    },


    STEERING_COMMITEE {
        @Override
        public List<Privilege> getPrivileges() {
            return Arrays.asList(new Privilege("READ_CONFERENCE"), new Privilege("WRITE_CONFERENCE"));
        }

        @Override
        public UserAllDataDto create(ModelMapper modelMapper, String encodedPassword, UserRegisterDto accountDto, RoleRepository roleRepository, AuthorRepository authorRepository) {
            SteeringCommittee steeringCommittee = modelMapper.map(accountDto, SteeringCommittee.class);
            steeringCommittee.getUser().setPassword(encodedPassword);
            steeringCommittee.getUser().setRoles(Collections.singletonList(roleRepository.findByName(name())));
            UserAllDataDto allData = modelMapper.map(steeringCommitteeRepository.save(steeringCommittee).getUser(), UserAllDataDto.class);
            allData.setEntityType(EntityType.AUTHOR);
            return allData;
        }
    };

    /**
     * Function for creating the privilege of each role -- an entity is seen as a role which is composed from different privileges
     */
    public abstract List<Privilege> getPrivileges();


    /**
     * Function for creating and saving an user based on its entity type
     *
     * @return Dto containing all user data
     */
    public abstract UserAllDataDto create(ModelMapper modelMapper, String encodedPassword, UserRegisterDto accountDto, RoleRepository roleRepository, BaseRepository authorRepository);
}

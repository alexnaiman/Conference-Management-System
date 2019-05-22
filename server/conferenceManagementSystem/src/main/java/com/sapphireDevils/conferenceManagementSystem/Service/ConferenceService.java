package com.sapphireDevils.conferenceManagementSystem.Service;


import com.sapphireDevils.conferenceManagementSystem.Dto.ConferenceDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Conference;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService extends BaseService<Conference> {


    @Autowired
    private ConferenceRepository conferenceRepository;


    @Override
    public BaseRepository<Conference> getRepository() {
        return conferenceRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return ConferenceDto.class;
    }
}

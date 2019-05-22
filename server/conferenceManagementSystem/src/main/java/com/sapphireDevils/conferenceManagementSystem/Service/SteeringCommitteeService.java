package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.AbstractAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.ConferenceDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.SteeringCommiteeDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Model.Conference;
import com.sapphireDevils.conferenceManagementSystem.Model.SteeringCommittee;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.ConferenceRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.SteeringCommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SteeringCommitteeService extends BaseService<SteeringCommittee> {

    @Autowired
    private SteeringCommitteeRepository steeringCommitteeRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Override
    public BaseRepository<SteeringCommittee> getRepository() {
        return steeringCommitteeRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return SteeringCommiteeDto.class;
    }


    public ConferenceDto createConference(Conference conference, int id) {
        SteeringCommittee steeringCommittee = getOne(id);
        if (steeringCommittee == null)
            throw new RuntimeException("Cannot find user");
        steeringCommittee.getConferences().add(conference);
        conference.setSteeringCommittee(steeringCommittee);
        conferenceRepository.save(conference);
        return modelMapper.map(conference, ConferenceDto.class);
    }
}

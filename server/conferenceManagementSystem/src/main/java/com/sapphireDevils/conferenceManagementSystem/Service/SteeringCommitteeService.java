package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.AbstractAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.ConferenceDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.SteeringCommiteeDto;
import com.sapphireDevils.conferenceManagementSystem.Model.*;
import com.sapphireDevils.conferenceManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SteeringCommitteeService extends BaseService<SteeringCommittee> {

    @Autowired
    private SteeringCommitteeRepository steeringCommitteeRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private ReviewerRepository reviewerRepository;

    @Autowired
    private ChairRepository chairRepository;

    @Override
    public BaseRepository<SteeringCommittee> getRepository() {
        return steeringCommitteeRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return SteeringCommiteeDto.class;
    }


    public ConferenceDto createConference(ConferenceDto conferenceDto, int id) {
        SteeringCommittee steeringCommittee = getOne(id);
        if (steeringCommittee == null)
            throw new RuntimeException("Cannot find user");
        Conference conference = modelMapper.map(conferenceDto, Conference.class);

        steeringCommittee.getConferences().add(conference);
        conference.setSteeringCommittee(steeringCommittee);

        Chair chair = chairRepository.findAll().stream().filter(x -> x.getUser().getEmail().equals(conferenceDto.getChairEmail())).collect(Collectors.toList()).get(0);

        chair.getConferences().add(conference);
        conference.setChair(chair);

        List<Reviewer> reviewers = new ArrayList<>();
        conferenceDto.getReviewers().forEach(rev -> reviewers.add(reviewerRepository.findAll().stream().filter(x -> x.getUser().getEmail().equals(rev)).collect(Collectors.toList()).get(0)));

        reviewers.forEach(rev -> {
            rev.getConferences().add(conference);
            conference.getReviewers().add(rev);
        });
        conferenceRepository.save(conference);
        return modelMapper.map(conference, ConferenceDto.class);
    }
}

package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.ReviewerDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Reviewer;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewerService extends BaseService<Reviewer> {

    @Autowired
    private ReviewerRepository reviewerRepository;

    @Override
    public BaseRepository<Reviewer> getRepository() {
        return reviewerRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return ReviewerDto.class;
    }
}

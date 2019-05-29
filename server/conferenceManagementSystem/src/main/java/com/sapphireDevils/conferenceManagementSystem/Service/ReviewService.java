package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.ReviewDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Review;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<Review> {


    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public BaseRepository<Review> getRepository() {
        return reviewRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return ReviewDto.class;
    }
}

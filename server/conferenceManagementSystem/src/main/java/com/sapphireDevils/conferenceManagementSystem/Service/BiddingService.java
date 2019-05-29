package com.sapphireDevils.conferenceManagementSystem.Service;


import com.sapphireDevils.conferenceManagementSystem.Dto.BiddingDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Bidding;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.BiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiddingService extends BaseService<Bidding> {

    @Autowired
    private BiddingRepository biddingRepository;


    @Override
    public BaseRepository<Bidding> getRepository() {
        return biddingRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return BiddingDto.class;
    }
}

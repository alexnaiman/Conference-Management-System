package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.ChairDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Chair;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChairService extends BaseService<Chair> {

    @Autowired
    ChairRepository chairRepository;

    @Override
    public BaseRepository<Chair> getRepository() {
        return chairRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return ChairDto.class;
    }
}

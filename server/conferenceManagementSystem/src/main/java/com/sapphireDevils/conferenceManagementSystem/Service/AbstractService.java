package com.sapphireDevils.conferenceManagementSystem.Service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sapphireDevils.conferenceManagementSystem.Dto.AbstractAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Repository.AbstractRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbstractService extends BaseService<Abstract> {
    @Autowired
    private AbstractRepository abstractRepository;


    @Override
    public BaseRepository<Abstract> getRepository() {
        return abstractRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return AbstractAllDataDto.class;
    }
}

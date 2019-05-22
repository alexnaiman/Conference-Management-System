package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.PaperAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaperService extends BaseService<Paper> {
    @Autowired
    private PaperRepository paperRepository;


    @Override
    public BaseRepository<Paper> getRepository() {
        return paperRepository;
    }

    public Optional<Paper> getByTitle(String title){return paperRepository.findByTitle(title);}

    @Override
    public Class<?> getBaseDtoClass() {
        return PaperAllDataDto.class;
    }
}

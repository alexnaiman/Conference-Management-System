package com.sapphireDevils.conferenceManagementSystem.Service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sapphireDevils.conferenceManagementSystem.Dto.AbstractAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.PaperAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Repository.AbstractRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperService extends BaseService<Paper> {
    @Autowired
    private PaperRepository paperRepository;


    @Override
    public BaseRepository<Paper> getRepository() {
        return paperRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return PaperAllDataDto.class;
    }

//    public PaperAllDataDto updatePaper(Paper pap, int id) {
//        Paper paper = paperRepository.getOne(id);
//        if (paper == null)
//            throw new RuntimeException("Cannot find paper");
//        paper.setContent(pap.getContent());
//        return modelMapper.map(paper, PaperAllDataDto.class);
//    }
}

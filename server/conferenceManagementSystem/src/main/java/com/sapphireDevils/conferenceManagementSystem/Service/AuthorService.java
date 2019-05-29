package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.AbstractAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.PaperAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Model.Conference;
import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<Author> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AbstractRepository abstractRepository;

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Override
    public BaseRepository<Author> getRepository() {
        return authorRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return UserAllDataDto.class;
    }

    public AbstractAllDataDto uploadAbstract(Abstract abs, int id, int conferenceId) {
        Author author = getOne(id);
        Conference conference = conferenceRepository.getOne(conferenceId);
        if (author == null)
            throw new RuntimeException("Cannot find user");
        if (conference == null)
            throw new RuntimeException("Cannot find conference");
        author.getAbstracts().add(abs);
        abs.getAuthors().add(author);

        conference.getAbstracts().add(abs);
        abs.setConference(conference);

        abstractRepository.save(abs);
        return modelMapper.map(abs, AbstractAllDataDto.class);
    }

    public PaperAllDataDto uploadPaper(Paper paper, int id, int conferenceId) {
        Author author = getOne(id);
        Conference conference = conferenceRepository.getOne(conferenceId);
        if (author == null)
            throw new RuntimeException("Cannot find user");
        if (conference == null)
            throw new RuntimeException("Cannot find conference");
        author.getPapers().add(paper);
        paper.getAuthors().add(author);

        conference.getPapers().add(paper);
        paper.setConference(conference);

        paperRepository.save(paper);
        return modelMapper.map(paper, PaperAllDataDto.class);
    }


}

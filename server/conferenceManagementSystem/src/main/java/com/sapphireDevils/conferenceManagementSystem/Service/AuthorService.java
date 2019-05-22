package com.sapphireDevils.conferenceManagementSystem.Service;

import com.sapphireDevils.conferenceManagementSystem.Dto.AbstractAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Dto.PaperAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Repository.AbstractRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.AuthorRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.BaseRepository;
import com.sapphireDevils.conferenceManagementSystem.Repository.PaperRepository;
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

    @Override
    public BaseRepository<Author> getRepository() {
        return authorRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return UserAllDataDto.class;
    }

    public AbstractAllDataDto uploadAbstract(Abstract abs, int id) {
        Author author = getOne(id);
        if (author == null)
            throw new RuntimeException("Cannot find user");
        author.getAbstracts().add(abs);
        abs.getAuthors().add(author);
        abstractRepository.save(abs);
        return modelMapper.map(abs, AbstractAllDataDto.class);
    }

    public PaperAllDataDto uploadPaper(Paper paper, int id){
        Author author = getOne(id);
        if (author == null)
            throw new RuntimeException("Cannot find user");
        author.getPapers().add(paper);
        paper.getAuthors().add(author);
        paperRepository.save(paper);
        return modelMapper.map(paper, PaperAllDataDto.class);
    }

}

package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Service.AuthorService;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController extends BaseController<Author> {

    @Autowired
    private AuthorService authorService;

    @Override
    public BaseService<Author> getService() {
        return authorService;
    }
}

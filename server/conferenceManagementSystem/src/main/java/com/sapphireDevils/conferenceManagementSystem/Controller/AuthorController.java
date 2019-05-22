package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Author;
import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Service.AbstractService;
import com.sapphireDevils.conferenceManagementSystem.Service.AuthorService;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController extends BaseController<Author> {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AbstractService abstractService;


    @Override
    public BaseService<Author> getService() {
        return authorService;
    }

    @PostMapping("/{id}/upload") // request gen localhost:9090/author/1/upload
    public Response uploadAbstract(@RequestBody Abstract abstractData, @PathVariable int id) {
        try {
            System.out.println(abstractData);
            return new Response(authorService.uploadAbstract(abstractData, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.getErrorResponse(e.getMessage());
        }
    }

    @PostMapping("/{id}/uploadpaper") // request gen localhost:9090/author/1/uploadpaper
    public Response uploadPaper(@RequestBody Paper paperData, @PathVariable int id) {
        try {
            System.out.println(paperData);
            return new Response(authorService.uploadPaper(paperData, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.getErrorResponse(e.getMessage());
        }
    }

    @Override
    @GetMapping
    public Response getAll() {
        // TODO de adaugat reguli pentru model mapper ca sa stie sa mergeuiasca mai adanc obiectele
        return new Response(getService().getAll(UserAllDataDto.class));
    }

}

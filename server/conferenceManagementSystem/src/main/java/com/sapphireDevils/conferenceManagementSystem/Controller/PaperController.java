//package com.sapphireDevils.conferenceManagementSystem.Controller;
//
//
//import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
//import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
//import com.sapphireDevils.conferenceManagementSystem.Service.PaperService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/paper")
//public class PaperController extends BaseController<Paper> {
//
//    @Autowired
//    PaperService paperService;
//
//    @Override
//    public BaseService<Paper> getService(){return paperService;}
//
//    @PostMapping("/{id}/upload") // request gen localhost:9090/author/1/upload
//    public Response uploadAbstract(@RequestBody Paper paperData, @PathVariable int id) {
//        try {
//            System.out.println(paperData);
////            Optional<Paper> optionalPaper = paperService.
//
//            return new Response(authorService.uploadAbstract(abstractData, id));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.getErrorResponse(e.getMessage());
//        }
//    }
//}

package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import com.sapphireDevils.conferenceManagementSystem.Service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paper")
public class PaperController extends BaseController<Paper>{
    @Autowired
    private PaperService paperService;

    @Override
    public BaseService<Paper> getService() {
        return paperService;
    }

    @PutMapping("/update") // request gen localhost:9090/paper/update
    public Response update(@RequestBody Paper paperData) {
        try {
            System.out.println(paperData);

            return new Response(paperService.update(paperData));

        } catch (Exception e) {
            e.printStackTrace();
            return Response.getErrorResponse(e.getMessage());
        }
    }
}

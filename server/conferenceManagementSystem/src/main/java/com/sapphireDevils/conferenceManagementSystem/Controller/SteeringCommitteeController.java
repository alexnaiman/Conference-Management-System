package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.Conference;
import com.sapphireDevils.conferenceManagementSystem.Model.SteeringCommittee;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import com.sapphireDevils.conferenceManagementSystem.Service.SteeringCommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steering")
public class SteeringCommitteeController extends BaseController<SteeringCommittee> {

    @Autowired
    private SteeringCommitteeService steeringCommitteeService;

    @Override
    public BaseService<SteeringCommittee> getService() {
        return steeringCommitteeService;
    }

    @PostMapping("/{id}/createConference")
    @PreAuthorize("hasAuthority('WRITE_CONFERENCE')") // DOAR ASTA MERGE
    public Response create(@RequestBody Conference entity, @PathVariable int id) {
        try {
            System.out.println(entity);
            return new Response(steeringCommitteeService.createConference(entity, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.getErrorResponse(e.getMessage());
        }
    }
}

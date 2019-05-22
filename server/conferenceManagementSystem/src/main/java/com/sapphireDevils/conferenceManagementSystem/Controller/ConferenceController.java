package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.Conference;
import com.sapphireDevils.conferenceManagementSystem.Model.SteeringCommittee;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import com.sapphireDevils.conferenceManagementSystem.Service.ConferenceService;
import com.sapphireDevils.conferenceManagementSystem.Service.SteeringCommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conference")
public class ConferenceController extends BaseController<Conference> {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private SteeringCommitteeService steeringCommitteeService;

    @Override
    public BaseService<Conference> getService() {
        return conferenceService;
    }

}

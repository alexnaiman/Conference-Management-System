package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.Reviewer;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import com.sapphireDevils.conferenceManagementSystem.Service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reviewer")
public class ReviewerController extends BaseController<Reviewer> {


    @Autowired
    private ReviewerService reviewerService;

    @Override
    public BaseService<Reviewer> getService() {
        return reviewerService;
    }
}

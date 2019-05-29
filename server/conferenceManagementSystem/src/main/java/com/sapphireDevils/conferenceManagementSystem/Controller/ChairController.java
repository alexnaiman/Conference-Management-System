package com.sapphireDevils.conferenceManagementSystem.Controller;

import com.sapphireDevils.conferenceManagementSystem.Model.Chair;
import com.sapphireDevils.conferenceManagementSystem.Service.BaseService;
import com.sapphireDevils.conferenceManagementSystem.Service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/chair")
public class ChairController extends BaseController<Chair> {

    @Autowired
    private ChairService chairService;


    @Override
    public BaseService<Chair> getService() {
        return chairService;
    }
}

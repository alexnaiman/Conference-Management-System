package com.sapphireDevils.conferenceManagementSystem.Dto;


import com.sapphireDevils.conferenceManagementSystem.Model.SteeringCommittee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConferenceDto extends BaseDto {
    private String name;
    private String location;
    private String theme;
    private Date date;
    private SteeringCommiteeDto steeringCommittee;
}

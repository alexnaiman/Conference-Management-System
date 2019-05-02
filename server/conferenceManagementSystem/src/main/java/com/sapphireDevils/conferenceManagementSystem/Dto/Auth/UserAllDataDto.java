package com.sapphireDevils.conferenceManagementSystem.Dto.Auth;


import com.sapphireDevils.conferenceManagementSystem.Dto.BaseDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.EntityType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAllDataDto extends BaseDto {
    private String name;
    private String email;
    private String password;
    private String affiliation;
    private String webpage;
    private EntityType entityType;

}

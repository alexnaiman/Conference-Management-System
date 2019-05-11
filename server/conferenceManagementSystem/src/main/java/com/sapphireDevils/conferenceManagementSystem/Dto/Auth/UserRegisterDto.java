package com.sapphireDevils.conferenceManagementSystem.Dto.Auth;

import com.sapphireDevils.conferenceManagementSystem.Dto.BaseDto;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.EntityType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegisterDto extends BaseDto {
    private String email;
    private String password;
    private String entityType;
    private String name;
    private String affiliation;
    private String webpage;
}

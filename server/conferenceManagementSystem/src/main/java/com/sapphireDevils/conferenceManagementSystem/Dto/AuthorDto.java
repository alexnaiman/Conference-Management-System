package com.sapphireDevils.conferenceManagementSystem.Dto;


import com.sapphireDevils.conferenceManagementSystem.Dto.Auth.UserAllDataDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthorDto extends BaseDto {
    private UserAllDataDto userData;
}

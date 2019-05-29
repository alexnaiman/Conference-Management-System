package com.sapphireDevils.conferenceManagementSystem.Dto;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChairDto extends BaseDto {

    private User user;
}

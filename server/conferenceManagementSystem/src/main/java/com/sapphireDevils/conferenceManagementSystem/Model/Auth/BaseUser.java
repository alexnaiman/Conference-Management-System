package com.sapphireDevils.conferenceManagementSystem.Model.Auth;


import com.sapphireDevils.conferenceManagementSystem.Model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class BaseUser extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}

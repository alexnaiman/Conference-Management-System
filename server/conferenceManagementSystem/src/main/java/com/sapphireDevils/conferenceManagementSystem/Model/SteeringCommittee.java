package com.sapphireDevils.conferenceManagementSystem.Model;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class SteeringCommittee extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User user;
}

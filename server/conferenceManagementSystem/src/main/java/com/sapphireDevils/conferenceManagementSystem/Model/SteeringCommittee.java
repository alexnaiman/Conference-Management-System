package com.sapphireDevils.conferenceManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.BaseUser;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"conferences"})
public class SteeringCommittee extends BaseUser {

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Conference> conferences;
}

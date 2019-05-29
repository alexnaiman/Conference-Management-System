package com.sapphireDevils.conferenceManagementSystem.Model;

import com.sapphireDevils.conferenceManagementSystem.Model.Auth.BaseUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Chair extends BaseUser {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Conference> conferences = new HashSet<>();
}

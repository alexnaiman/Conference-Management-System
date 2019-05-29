package com.sapphireDevils.conferenceManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sapphireDevils.conferenceManagementSystem.Model.Auth.BaseUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Reviewer extends BaseUser {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    Set<Review> reviews = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    Set<Bidding> biddings = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Conference> conferences = new HashSet<>();
}

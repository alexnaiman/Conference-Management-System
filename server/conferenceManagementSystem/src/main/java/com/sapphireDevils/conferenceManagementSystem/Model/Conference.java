package com.sapphireDevils.conferenceManagementSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"steeringCommittee", "chair", "abstracts", "papers", "reviews"})
public class Conference extends BaseEntity {

    private String name;
    private String location;
    private String theme;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SteeringCommittee steeringCommittee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Chair chair;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Abstract> abstracts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Paper> papers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Reviewer> reviewers = new HashSet<>();


}

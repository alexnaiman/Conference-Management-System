package com.sapphireDevils.conferenceManagementSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"steeringCommittee"})
public class Conference extends BaseEntity {

    private String name;
    private String location;
    private String theme;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SteeringCommittee steeringCommittee;
}

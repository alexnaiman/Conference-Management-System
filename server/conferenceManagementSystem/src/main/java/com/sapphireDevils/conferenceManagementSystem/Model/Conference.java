package com.sapphireDevils.conferenceManagementSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Conference extends BaseEntity {

    private String name;
    private String location;
    private String theme;
    private Date date;


}

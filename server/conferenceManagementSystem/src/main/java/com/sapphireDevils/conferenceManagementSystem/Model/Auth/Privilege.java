package com.sapphireDevils.conferenceManagementSystem.Model.Auth;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sapphireDevils.conferenceManagementSystem.Model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Privilege extends BaseEntity {

    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege() {
        super();
    }

    public Privilege(final String name) {
        super();
        this.name = name;
    }

}
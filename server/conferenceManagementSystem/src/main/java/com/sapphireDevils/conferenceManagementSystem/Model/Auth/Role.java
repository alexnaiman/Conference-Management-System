package com.sapphireDevils.conferenceManagementSystem.Model.Auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sapphireDevils.conferenceManagementSystem.Model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    private String name;

    public Role(String name) {
        this.name = name;
    }
}
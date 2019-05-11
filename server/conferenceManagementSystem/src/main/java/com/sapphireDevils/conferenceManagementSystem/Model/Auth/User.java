package com.sapphireDevils.conferenceManagementSystem.Model.Auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sapphireDevils.conferenceManagementSystem.Model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;


@Entity
@Table(name = "user_entity", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String affiliation;
    @NotNull
    private String webpage;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private boolean tokenExpired;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}


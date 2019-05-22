package com.sapphireDevils.conferenceManagementSystem.Model;


import com.sapphireDevils.conferenceManagementSystem.Model.Auth.BaseUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"abstracts"})
public class Author extends BaseUser {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Abstract> abstracts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Paper> papers = new HashSet<>();
}

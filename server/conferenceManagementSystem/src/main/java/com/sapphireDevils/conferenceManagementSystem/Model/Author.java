package com.sapphireDevils.conferenceManagementSystem.Model;


import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"abstracts"})
public class Author extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Abstract> abstracts = new HashSet<>();
}

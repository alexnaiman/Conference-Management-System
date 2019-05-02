package com.sapphireDevils.conferenceManagementSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Abstract extends BaseEntity {

    private String title;
    private String content; // todo make to store file

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authors;
}

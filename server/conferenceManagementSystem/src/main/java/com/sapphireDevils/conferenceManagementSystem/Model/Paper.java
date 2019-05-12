package com.sapphireDevils.conferenceManagementSystem.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"authors"})
public class Paper extends BaseEntity{
    @NotNull
    private String title;
    @NotNull
    private String content; // TODO make to store file

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();
}

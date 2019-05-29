package com.sapphireDevils.conferenceManagementSystem.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntity {


    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Reviewer reviewer;


    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Paper paper;

    private ReviewStatus status;

}

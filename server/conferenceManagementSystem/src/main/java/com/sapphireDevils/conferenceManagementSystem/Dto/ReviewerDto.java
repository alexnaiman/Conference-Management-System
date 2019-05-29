package com.sapphireDevils.conferenceManagementSystem.Dto;


import com.sapphireDevils.conferenceManagementSystem.Model.Auth.User;
import com.sapphireDevils.conferenceManagementSystem.Model.Bidding;
import com.sapphireDevils.conferenceManagementSystem.Model.Review;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewerDto extends BaseDto {

    private User user;

    Set<Review> reviews = new HashSet<>();

    Set<Bidding> biddings = new HashSet<>();

}

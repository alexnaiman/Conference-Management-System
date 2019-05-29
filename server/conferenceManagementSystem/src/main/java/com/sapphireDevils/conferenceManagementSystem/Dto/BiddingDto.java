package com.sapphireDevils.conferenceManagementSystem.Dto;

import com.sapphireDevils.conferenceManagementSystem.Model.Abstract;
import com.sapphireDevils.conferenceManagementSystem.Model.Reviewer;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class BiddingDto extends BaseDto {

    private Reviewer reviewer;

    private Abstract anAbstract;

    private boolean wantToReview;

}

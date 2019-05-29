package com.sapphireDevils.conferenceManagementSystem.Dto;

import com.sapphireDevils.conferenceManagementSystem.Model.Paper;
import com.sapphireDevils.conferenceManagementSystem.Model.ReviewStatus;
import com.sapphireDevils.conferenceManagementSystem.Model.Reviewer;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewDto extends BaseDto {
    private Reviewer reviewer;
    private Paper paper;
    private ReviewStatus status;
}

package com.sapphireDevils.conferenceManagementSystem.Dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaperAllDataDto extends BaseDto {
    private String title;
    private String content;
    private Set<AuthorDto> authors;
}

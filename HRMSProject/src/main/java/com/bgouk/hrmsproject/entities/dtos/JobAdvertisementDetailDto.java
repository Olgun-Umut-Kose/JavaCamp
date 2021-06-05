package com.bgouk.hrmsproject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailDto {

    private String jobDescription;

    private Integer minSalary;

    private Integer maxSalary;

    private int quota;

    private LocalDateTime appealDeadline;

    private LocalDateTime updatedDate;

    private boolean isActivated;

    private String employerName;

    private String cityName;

    private String jobTitle;

}

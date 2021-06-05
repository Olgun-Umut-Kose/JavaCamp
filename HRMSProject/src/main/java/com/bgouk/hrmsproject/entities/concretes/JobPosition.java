package com.bgouk.hrmsproject.entities.concretes;

import com.bgouk.hrmsproject.entities.abstracts.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "updated_date",nullable = true)
    private LocalDateTime updatedDate;

    @Column(name="is_deleted",nullable = false)
    private boolean isDeleted= false;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition",fetch = FetchType.LAZY,targetEntity = JobAdvertisement.class)
    private List<JobAdvertisement> jobAdvertisements;
}

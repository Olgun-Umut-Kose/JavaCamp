package com.bgouk.hrmsproject.entities.concretes;

import com.bgouk.hrmsproject.entities.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement extends AbstractEntity {

    @Column(name = "job_description",nullable = false)
    private String jobDescription;

    @Column(name = "min_salary",nullable = true)
    private Integer minSalary;

    @Column(name = "max_salary",nullable = true)
    private Integer maxSalary;

    @Column(name = "quota",nullable = false)
    private int quota;

    @Column(name = "appeal_deadline",nullable = true)
    private LocalDateTime appealDeadline;

    @Column(name = "updated_date",nullable = true)
    private LocalDateTime updatedDate;

    @Column(name="is_deleted",nullable = false)
    private boolean isDeleted= false;

    @Column(name="is_activated",nullable = false)
    private boolean isActivated= true;

    @ManyToOne(targetEntity = JobPosition.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id",referencedColumnName = "id",nullable = false)
    private JobPosition jobPosition;

    @ManyToOne(targetEntity = City.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",referencedColumnName = "id",nullable = false)
    private City city;

    @ManyToOne(targetEntity = Employer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id",referencedColumnName = "id",nullable = false)
    private Employer employer;

}

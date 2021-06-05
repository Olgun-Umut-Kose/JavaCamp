package com.bgouk.hrmsproject.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY,targetEntity = JobAdvertisement.class)
    private List<JobAdvertisement> jobAdvertisements;
}

package com.bgouk.hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;
}

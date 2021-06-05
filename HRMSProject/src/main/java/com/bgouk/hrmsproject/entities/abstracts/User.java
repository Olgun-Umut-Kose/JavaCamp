package com.bgouk.hrmsproject.entities.abstracts;

import com.bgouk.hrmsproject.entities.concretes.ActivationCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public abstract class User extends AbstractEntity{

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @JsonIgnore
    @Formula("type")
    private String type;

    @Column(name = "updated_date",nullable = true)
    private LocalDateTime updatedDate;

    @Column(name="is_deleted",nullable = false)
    private boolean isDeleted= false;

    @Column(name="is_activated",nullable = false)
    private boolean isActivated=true;

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = ActivationCode.class)
    private List<ActivationCode> activationCodes;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

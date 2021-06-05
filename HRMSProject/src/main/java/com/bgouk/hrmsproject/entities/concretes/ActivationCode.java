package com.bgouk.hrmsproject.entities.concretes;

import com.bgouk.hrmsproject.entities.abstracts.AbstractEntity;
import com.bgouk.hrmsproject.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activation_codes")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationCode extends AbstractEntity {

//    @Column(name = "user_id")
//    private int userId;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "is_confirmed")
    private Boolean isConfirmed = false;

    @Column(name = "confirmed_date")
    private LocalDateTime confirmedDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate = LocalDateTime.now().plusDays(1);

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


    public ActivationCode(String code, User user) {
        this.activationCode = code;

        this.user = user;
    }
}

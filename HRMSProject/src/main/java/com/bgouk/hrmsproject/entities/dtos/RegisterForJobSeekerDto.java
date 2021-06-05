package com.bgouk.hrmsproject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RegisterForJobSeekerDto extends RegisterDto {
    private String nationalIdentity;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;

}

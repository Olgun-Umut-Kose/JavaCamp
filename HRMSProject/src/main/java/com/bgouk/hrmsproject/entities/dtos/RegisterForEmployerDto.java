package com.bgouk.hrmsproject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RegisterForEmployerDto extends RegisterDto {
    private String companyName;
    private String webAddress;
    private String phoneNumber;

}

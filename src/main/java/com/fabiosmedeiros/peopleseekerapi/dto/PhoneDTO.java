package com.fabiosmedeiros.peopleseekerapi.dto;

import com.fabiosmedeiros.peopleseekerapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*
    As annotations @Data e @Builder são utilizadas para geração
    automática de código, como por exemplo, os getters e setters.
    As annotations @AllArgsConstructor e @NoArgsConstructor
    geram construtor, com e sem parâmetros.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    // A annotation @Enumerated instrui a JPA na conversão de um enum.
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}

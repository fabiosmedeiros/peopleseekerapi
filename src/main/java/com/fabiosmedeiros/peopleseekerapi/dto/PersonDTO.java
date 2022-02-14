package com.fabiosmedeiros.peopleseekerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/*
 * DTO, ou Data Transfer Object, como o próprio nome sugere, é usado
 * apenas para transferir dados. É um objeto simples, que não contém
 * qualquer lógica de negócio.
 * Em relação as annotations utilizadas, temos:
 * @NotEmpty não permite nulos
 * @Size define o mínimo/máximode  caracteres permitidos
 * @CPF realiza a validação de um CPF
 * @Valid valida de dado é válido ou não
 * As annotations @Data e @Builder são utilizadas para geração
 * automática de código, como por exemplo, os getters e setters
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min =2, max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}

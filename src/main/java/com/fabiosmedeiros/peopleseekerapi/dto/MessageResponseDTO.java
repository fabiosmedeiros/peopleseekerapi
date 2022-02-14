package com.fabiosmedeiros.peopleseekerapi.dto;

import lombok.Builder;
import lombok.Data;

/* As annotations @Data e @Builder são utilizadas para geração
   automática de código, como por exemplo, os getters e setters */
@Data
@Builder
public class MessageResponseDTO {

    private String message;

}

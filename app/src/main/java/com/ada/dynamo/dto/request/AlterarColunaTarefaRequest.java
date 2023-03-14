package com.ada.dynamo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AlterarColunaTarefaRequest {

    @NotBlank
    private String fromColunaId;
    @NotBlank
    private String toColunaId;

}

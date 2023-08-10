package com.ada.dynamo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class AlterarColunaTarefaRequest {
    @NotBlank
    private String fromColunaId;
    @NotBlank
    private String toColunaId;
}

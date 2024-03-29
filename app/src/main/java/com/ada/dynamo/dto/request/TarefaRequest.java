package com.ada.dynamo.dto.request;

import com.ada.dynamo.model.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TarefaRequest {
    @NotBlank
    private String colunaId;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private Prioridade prioridade;
    @NotNull
    private LocalDateTime previsao;
}

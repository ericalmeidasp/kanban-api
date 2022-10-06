package com.ada.dynamo.dto.request;

import com.ada.dynamo.model.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class TarefaRequest {
    private String colunaId;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private Prioridade prioridade;
    @NotBlank
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime previsao;
}

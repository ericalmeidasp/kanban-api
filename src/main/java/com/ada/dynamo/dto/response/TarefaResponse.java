package com.ada.dynamo.dto.request;

import com.ada.dynamo.model.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TarefaRequest {
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime previsao;
}

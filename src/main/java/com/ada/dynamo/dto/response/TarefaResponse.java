package com.ada.dynamo.dto.response;

import com.ada.dynamo.model.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TarefaResponse {
    private String id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime previsao;
}

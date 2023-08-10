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
    private LocalDateTime previsao;
}

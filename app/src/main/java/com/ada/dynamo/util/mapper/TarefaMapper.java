package com.ada.dynamo.util.mapper;

import com.ada.dynamo.dto.response.TarefaResponse;
import com.ada.dynamo.model.Tarefa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper extends TodoMapper<TarefaResponse,Tarefa> {
    public TarefaMapper(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    Class<Tarefa> getModelClass() {
        return Tarefa.class;
    }
    @Override
    Class<TarefaResponse> getResponseClass() {
        return TarefaResponse.class;
    }
}

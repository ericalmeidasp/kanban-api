package com.ada.dynamo.mapper;

import com.ada.dynamo.dto.request.ColunaRequest;
import com.ada.dynamo.dto.request.TarefaRequest;
import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.dto.response.TarefaResponse;
import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.model.Tarefa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    Tarefa requestToModel(TarefaRequest tarefaRequest);

    TarefaResponse modelToResponse(Tarefa tarefa);

    List<TarefaResponse> modelListToResponseList(List<Tarefa> tarefaList);
}

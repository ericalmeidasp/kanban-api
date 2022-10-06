package com.ada.dynamo.mapper;

import com.ada.dynamo.dto.request.ColunaRequest;
import com.ada.dynamo.dto.request.QuadroRequest;
import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.model.Quadro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColunaMapper {

    Coluna requestToModel(ColunaRequest colunaRequest);

    ColunaResponse modelToResponse(Coluna coluna);

    List<ColunaResponse> modelListToResponseList(List<Coluna> colunaList);
}

package com.ada.dynamo.util.mapper;

import com.ada.dynamo.dto.request.QuadroRequest;
import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.model.Quadro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuadroMapper {

    Quadro requestToModel(QuadroRequest quadroRequest);

    QuadroResponse modelToResponse(Quadro quadro);

    List<QuadroResponse> modelListToResponseList(List<Quadro> quadroList);
}

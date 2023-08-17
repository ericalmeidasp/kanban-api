package com.ada.dynamo.util.mapper;

import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.model.Coluna;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ColunaMapper extends TodoMapper<ColunaResponse,Coluna>{
    public ColunaMapper(ObjectMapper objectMapper) {
        super(objectMapper);
    }
    @Override
    Class<Coluna> getModelClass() {
        return Coluna.class;
    }
    @Override
    Class<ColunaResponse> getResponseClass() {
        return ColunaResponse.class;
    }
}

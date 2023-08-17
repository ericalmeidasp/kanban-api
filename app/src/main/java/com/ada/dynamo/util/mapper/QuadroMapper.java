package com.ada.dynamo.util.mapper;

import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.model.Quadro;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class QuadroMapper extends TodoMapper<QuadroResponse, Quadro> {
    public QuadroMapper(ObjectMapper objectMapper) {
        super(objectMapper);
    }
    @Override
    Class<Quadro> getModelClass() {
        return Quadro.class;
    }
    @Override
    Class<QuadroResponse> getResponseClass() {
        return QuadroResponse.class;
    }
}

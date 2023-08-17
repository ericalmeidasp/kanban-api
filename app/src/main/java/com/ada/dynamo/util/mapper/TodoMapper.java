package com.ada.dynamo.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public abstract class TodoMapper<RESPONSE, MODEL> {
    protected final ObjectMapper objectMapper;
    protected TodoMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public MODEL requestToModel(Object request) {
        return objectMapper.convertValue(request, getModelClass());
    }
    public RESPONSE modelToResponse(MODEL model) {
        return objectMapper.convertValue(model, getResponseClass());
    }
    @SuppressWarnings("unchecked")
    public List<RESPONSE> modelListToResponseList(List<MODEL> modelList) {
        return objectMapper.convertValue(modelList, List.class);
    }
    abstract Class<MODEL> getModelClass();
    abstract Class<RESPONSE> getResponseClass();
}

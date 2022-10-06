package com.ada.dynamo.service;

import com.ada.dynamo.dto.request.ColunaRequest;
import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.mapper.ColunaMapper;
import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.repository.ColunaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ColunaService {
    private final ColunaMapper mapper;
    private final ColunaRepository repository;

    public ColunaResponse adicionar(ColunaRequest colunaRequest) {
        Coluna coluna = mapper.requestToModel(colunaRequest);
        coluna.setTipo(repository.getEntityName());
        coluna.setId(String.format("%s#%s", colunaRequest.getQuadroId(), UUID.randomUUID()));

        return mapper.modelToResponse(repository.save(coluna));
    }

    public ColunaResponse exibir(String id) {
        return mapper.modelToResponse(repository.findById(id));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public List<ColunaResponse> listar() {
        return mapper.modelListToResponseList(repository.findAll());
    }
}

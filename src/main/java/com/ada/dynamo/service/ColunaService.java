package com.ada.dynamo.service;

import com.ada.dynamo.dto.request.ColunaRequest;
import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.repository.QuadroRepository;
import com.ada.dynamo.util.mapper.ColunaMapper;
import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.repository.ColunaRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ColunaService {
    private final ColunaMapper mapper;
    private final ColunaRepository repository;
    private final QuadroService quadroService;

    public ColunaResponse adicionar(ColunaRequest colunaRequest) {
        Coluna coluna = mapper.requestToModel(colunaRequest);
        coluna.setTipo(repository.getEntityName());

        String quadroId = verificarQuadroERetornaId(colunaRequest.getQuadroId());

        coluna.setId(String.format("%s#%s", quadroId, UUID.randomUUID()));

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

    public List<ColunaResponse> listarPorQuadro(String quadroId) {
        return mapper.modelListToResponseList(repository.listByQuadro(quadroId));
    }

    private String verificarQuadroERetornaId(String id) {
        return quadroService.verificarQuadroERetornaId(id);
    }
}

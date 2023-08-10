package com.ada.dynamo.service;

import com.ada.dynamo.dto.request.QuadroRequest;
import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.util.mapper.QuadroMapper;
import com.ada.dynamo.model.Quadro;
import com.ada.dynamo.repository.QuadroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuadroService {
    private final QuadroMapper mapper;
    private final QuadroRepository repository;

    public QuadroResponse adicionar(QuadroRequest quadroRequest) {
        Quadro quadro = mapper.requestToModel(quadroRequest);
        quadro.setId(UUID.randomUUID().toString());
        quadro.setTipo(repository.getEntityName());
        return mapper.modelToResponse(repository.save(quadro));
    }

    public QuadroResponse exibir(String id) {
        return mapper.modelToResponse(repository.findById(id));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public List<QuadroResponse> listar() {
        return mapper.modelListToResponseList(repository.findAll());
    }

    public String verificarQuadroERetornaId(String id) {
        return repository.findById(id).getId();
    }
}

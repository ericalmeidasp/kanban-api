package com.ada.dynamo.service;

import com.ada.dynamo.dto.request.QuadroRequest;
import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.mapper.QuadroMapper;
import com.ada.dynamo.model.Quadro;
import com.ada.dynamo.repository.QuadroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuadroService {
    private final QuadroMapper mapper;
    private final QuadroRepository repository;

    public QuadroResponse adicionar(QuadroRequest quadroRequest) {
        Quadro quadro = mapper.quadroRequestToModel(quadroRequest);

        quadro.setTipo(repository.getEntityName());

        return mapper.modelToQuadroResponse(repository.save(quadro));
    }

    public QuadroResponse exibir(String id) {
        return mapper.modelToQuadroResponse(repository.findById(id));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public List<QuadroResponse> listar() {
        return mapper.modelListToResponseList(repository.findAll());
    }
}

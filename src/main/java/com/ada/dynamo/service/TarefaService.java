package com.ada.dynamo.service;

import com.ada.dynamo.dto.request.AlterarColunaTarefaRequest;
import com.ada.dynamo.dto.request.TarefaRequest;
import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.dto.response.TarefaResponse;
import com.ada.dynamo.util.mapper.TarefaMapper;
import com.ada.dynamo.model.Tarefa;
import com.ada.dynamo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaMapper mapper;
    private final TarefaRepository repository;

    public TarefaResponse adicionar(TarefaRequest tarefaRequest) {
        Tarefa tarefa = mapper.requestToModel(tarefaRequest);
        tarefa.setTipo(repository.getEntityName());
        tarefa.setId(String.format("%s#%s", tarefaRequest.getColunaId(), UUID.randomUUID()));

        return mapper.modelToResponse(repository.save(tarefa));
    }

    public TarefaResponse exibir(String id) {
        return mapper.modelToResponse(repository.findById(id));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public List<TarefaResponse> listar() {
        return mapper.modelListToResponseList(repository.findAll());
    }

    public List<TarefaResponse> listarPorColuna(String colunaId) {
        return mapper.modelListToResponseList(repository.listByColuna(colunaId));
    }

    public TarefaResponse alterarTarefa(TarefaRequest tarefaRequest, String id) {
        Tarefa tarefa = repository.findById(id);

        tarefa.setTitulo(tarefaRequest.getTitulo());
        tarefa.setDescricao(tarefaRequest.getDescricao());
        tarefa.setPrioridade(tarefaRequest.getPrioridade());
        tarefa.setPrevisao(tarefaRequest.getPrevisao());

        repository.save(tarefa);

        return mapper.modelToResponse(tarefa);
    }

    public TarefaResponse alterarColunaTarefa(AlterarColunaTarefaRequest request, String id) {
        Tarefa tarefa = repository.findById(id);
        String novoId = tarefa.getId().replace(request.getFromColunaId(), request.getToColunaId());

        tarefa.setId(novoId);

        repository.deleteById(id);
        repository.save(tarefa);

        return mapper.modelToResponse(tarefa);
    }

    public TarefaResponse concluirTarefa(String id) {
        Tarefa tarefa = repository.findById(id);
        tarefa.setConclusao(LocalDateTime.now());
        repository.save(tarefa);

        return mapper.modelToResponse(tarefa);
    }


}

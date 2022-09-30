package com.ada.dynamo.repository;

import com.ada.dynamo.model.Tarefa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TarefaRepository {

    private final DynamoDBMapper mapper;


    public Tarefa save(Tarefa tarefa) {
        tarefa.setId(UUID.randomUUID());
        mapper.save(tarefa);
        return tarefa;
    }


    public Tarefa findById(UUID id) {
        return mapper.load(Tarefa.class, id);
    }

    public Iterable<Tarefa> findAll() {
        return mapper.scan(Tarefa.class, new DynamoDBScanExpression())
                .stream()
                .collect(Collectors.toList());
    }


}

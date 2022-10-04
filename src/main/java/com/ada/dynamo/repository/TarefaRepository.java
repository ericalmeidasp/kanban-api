package com.ada.dynamo.repository;

import com.ada.dynamo.model.Tarefa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TarefaRepository extends AbstractRepository<Tarefa, String> {
    public TarefaRepository(DynamoDBMapper mapper) {
        super(mapper);
    }

    @Override
    protected Class<Tarefa> getClassType() {
        return Tarefa.class;
    }
}

package com.ada.dynamo.repository;

import com.ada.dynamo.model.Tarefa;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Repository
public class TarefaRepository extends AbstractRepository<Tarefa> {
    public TarefaRepository(DynamoDbEnhancedClient enhancedClient) {
        super(enhancedClient);
    }

    @Override
    protected Class<Tarefa> getClassType() {
        return Tarefa.class;
    }
}

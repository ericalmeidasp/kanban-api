package com.ada.dynamo.repository;

import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.model.Tarefa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class TarefaRepository extends AbstractRepository<Tarefa, String> {
    public TarefaRepository(DynamoDBMapper mapper) {
        super(mapper);
    }

    @Override
    protected Class<Tarefa> getClassType() {
        return Tarefa.class;
    }

    public List<Tarefa> listByColuna(String colunaId) {
        Map<String, AttributeValue> eav = new HashMap<>();

        eav.put(":val1", new AttributeValue().withS(getEntityName()));
        eav.put(":val2", new AttributeValue().withS(colunaId));

        DynamoDBQueryExpression<Tarefa> queryExpression = new DynamoDBQueryExpression<Tarefa>()
                .withKeyConditionExpression("tipo = :val1 and begins_with (id, :val2)")
                .withExpressionAttributeValues(eav);

        return mapper.query(getClassType(), queryExpression);
    }
}

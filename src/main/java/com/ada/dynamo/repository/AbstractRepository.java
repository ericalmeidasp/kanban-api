package com.ada.dynamo.repository;

import com.ada.dynamo.model.Tarefa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class AbstractRepository<T, K> {

    protected final DynamoDBMapper mapper;

    public T save(T obj) {
        mapper.save(obj);
        return obj;
    }

    public void deleteById(K id) {
        mapper.delete(findById(id));
    }


    public T findById(K id) {
        return mapper.load(getClassType(), getEntityName(), id);
    }

    public List<T> findAll() {

        Map<String, AttributeValue> eav = new HashMap<>();

        eav.put(":val1", new AttributeValue()
                .withS(getEntityName()));

        DynamoDBQueryExpression<T> queryExpression = new DynamoDBQueryExpression<T>()
                .withKeyConditionExpression("tipo = :val1")
                .withExpressionAttributeValues(eav);

        return mapper.query(getClassType(), queryExpression);
    }

    protected abstract Class<T> getClassType();

    public String getEntityName() {
        return getClassType().getSimpleName().toLowerCase();
    }
}

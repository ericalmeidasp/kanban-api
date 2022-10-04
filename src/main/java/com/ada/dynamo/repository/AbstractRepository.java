package com.ada.dynamo.repository;

import com.ada.dynamo.model.Tarefa;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class AbstractRepository<T, K> {

    private final DynamoDBMapper mapper;

    public T save(T obj) {
        mapper.save(obj);
        return obj;
    }

    public void deleteById(K id, K sortKey) {
        mapper.delete(findById(id, sortKey));
    }


    public T findById(K id, K sortKey) {
        return mapper.load(getClassType(), id, sortKey);
    }

    public List<T> findAll(String sort) {

        Map<String, AttributeValue> eav = new HashMap<>();

        eav.put(":val1", new AttributeValue().withS(sort));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("tipo = :val1")
                .withExpressionAttributeValues(eav);

        return mapper.scan(getClassType(), scanExpression);
    }

    protected abstract Class<T> getClassType();
}

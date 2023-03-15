package com.ada.dynamo.repository;

import com.ada.dynamo.exception.ItemNaoEncontradoException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        return Optional.ofNullable(mapper.load(getClassType(), getEntityName(), id))
                .orElseThrow(ItemNaoEncontradoException::new);
    }

    public List<T> findAll() {
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":val1", new AttributeValue().withS(getEntityName()));
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

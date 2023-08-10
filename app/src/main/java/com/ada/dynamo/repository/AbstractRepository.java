package com.ada.dynamo.repository;

import com.ada.dynamo.exception.ItemNaoEncontradoException;
import com.ada.dynamo.model.Coluna;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.*;

public abstract class AbstractRepository<T> {
    protected final TableSchema<T> tableSchema;
    protected final DynamoDbTable<T> customerTable;

    public AbstractRepository(DynamoDbEnhancedClient enhancedClient) {
        tableSchema = TableSchema.fromBean(getClassType());
        customerTable = enhancedClient.table("quadros", tableSchema);
    }

    public T save(T obj) {
        customerTable.putItem(obj);
        return obj;
    }

    public void deleteById(String id) {
        customerTable.deleteItem(keyGenerator(id));
    }

    public T findById(String id) {
        return Optional.ofNullable(customerTable.getItem(keyGenerator(id)))
                .orElseThrow(ItemNaoEncontradoException::new);
    }

    public List<T> findAll() {
        QueryConditional keyEqual = QueryConditional.keyEqualTo(b -> b.partitionValue(getEntityName()));

        QueryEnhancedRequest tableQuery = QueryEnhancedRequest.builder()
                .queryConditional(keyEqual)
                .build();

        List<T> listItems = new ArrayList<>();

        var iteratorPages = customerTable.query(tableQuery).iterator();

        while (iteratorPages.hasNext()) {
            listItems.addAll(iteratorPages.next().items());
        }

        return listItems;
    }

    public List<T> listByAnterior(String anteriorId) {

        QueryConditional keyEqual = QueryConditional
                .sortBeginsWith(keyGenerator(anteriorId));

        QueryEnhancedRequest tableQuery = QueryEnhancedRequest.builder()
                .queryConditional(keyEqual)
                .build();

        List<T> listItems = new ArrayList<>();

        var iteratorPages = customerTable.query(tableQuery).iterator();

        while (iteratorPages.hasNext()) {
            listItems.addAll(iteratorPages
                    .next()
                    .items()
            );
        }

        return listItems;
    }

    protected abstract Class<T> getClassType();

    public String getEntityName() {
        return getClassType().getSimpleName().toLowerCase();
    }

    protected Key keyGenerator(String id) {
        return Key.builder()
                .partitionValue(getEntityName())
                .sortValue(id)
                .build();
    }
}

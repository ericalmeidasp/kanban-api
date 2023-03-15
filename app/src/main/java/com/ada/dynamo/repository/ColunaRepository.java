package com.ada.dynamo.repository;

import com.ada.dynamo.model.Coluna;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ColunaRepository extends AbstractRepository<Coluna, String> {
    public ColunaRepository(DynamoDBMapper mapper) {
        super(mapper);
    }

    @Override
    protected Class<Coluna> getClassType() {
        return Coluna.class;
    }

    public PaginatedQueryList<Coluna> listByQuadro(String quadroId) {
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":val1", new AttributeValue().withS(getEntityName()));
        eav.put(":val2", new AttributeValue().withS(quadroId));
        DynamoDBQueryExpression<Coluna> queryExpression = new DynamoDBQueryExpression<Coluna>()
                .withKeyConditionExpression("tipo = :val1 and begins_with (id, :val2)")
                .withExpressionAttributeValues(eav);
        return mapper.query(getClassType(), queryExpression);
    }
}

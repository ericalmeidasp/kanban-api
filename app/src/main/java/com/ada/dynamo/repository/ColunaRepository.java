package com.ada.dynamo.repository;

import com.ada.dynamo.model.Coluna;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
@Repository
public class ColunaRepository extends AbstractRepository<Coluna> {
    public ColunaRepository(DynamoDbEnhancedClient enhancedClient) {
        super(enhancedClient);
    }

    @Override
    protected Class<Coluna> getClassType() {
        return Coluna.class;
    }
}

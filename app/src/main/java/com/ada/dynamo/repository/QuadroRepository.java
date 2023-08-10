package com.ada.dynamo.repository;

import com.ada.dynamo.model.Quadro;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Repository
public class QuadroRepository extends AbstractRepository<Quadro> {
    public QuadroRepository(DynamoDbEnhancedClient enhancedClient) {
        super(enhancedClient);
    }

    @Override
    protected Class<Quadro> getClassType() {
        return Quadro.class;
    }
}

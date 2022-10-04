package com.ada.dynamo.repository;

import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.model.Quadro;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;


@Repository
public class ColunaRepository extends AbstractRepository<Coluna, String> {
    public ColunaRepository(DynamoDBMapper mapper) {
        super(mapper);
    }

    @Override
    protected Class<Coluna> getClassType() {
        return Coluna.class;
    }
}

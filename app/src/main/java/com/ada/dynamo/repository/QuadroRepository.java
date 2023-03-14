package com.ada.dynamo.repository;

import com.ada.dynamo.model.Quadro;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;


@Repository
public class QuadroRepository extends AbstractRepository<Quadro, String> {
    public QuadroRepository(DynamoDBMapper mapper) {
        super(mapper);
    }

    @Override
    protected Class<Quadro> getClassType() {
        return Quadro.class;
    }
}

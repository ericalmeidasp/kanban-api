package com.ada.dynamo.repository;

import com.ada.dynamo.model.Quadro;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class QuadroRepository {

    private final DynamoDBMapper mapper;

    public Quadro save(Quadro quadro) {
        quadro.setId(UUID.randomUUID().toString());
        mapper.save(quadro);
        return quadro;
    }
}

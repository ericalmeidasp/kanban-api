package com.ada.dynamo.model;

import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@Setter
@ToString
public class Quadro {
    private String id;
    private String tipo;
    private String name;

    @DynamoDbSortKey
    public String getId() {
        return id;
    }
    @DynamoDbPartitionKey
    public String getTipo() {
        return tipo;
    }
    public String getName() {
        return name;
    }
}

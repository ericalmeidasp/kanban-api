package com.ada.dynamo.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@Setter
public class Coluna {
    private String id;
    private String tipo;
    private String name;
    private String cor;
    private Integer ordem;
    private Integer limite;

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

    public String getCor() {
        return cor;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public Integer getLimite() {
        return limite;
    }
}

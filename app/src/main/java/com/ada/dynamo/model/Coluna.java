package com.ada.dynamo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "quadros")
@Data
public class Coluna {
    @DynamoDBRangeKey
    private String id;
    @DynamoDBHashKey
    private String tipo;
    private String name;
    private String cor;
    private Integer ordem;
    private Integer limite;
}

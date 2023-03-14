package com.ada.dynamo.model;


import com.ada.dynamo.util.autogenerate.LocalDateTimeAutoGenerate;
import com.ada.dynamo.util.converter.LocalDateTimeToStringConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.LocalDateTime;

@DynamoDBTable(tableName = "quadros")
@Data
public class Tarefa {
    @DynamoDBRangeKey
    private String id;
    @DynamoDBHashKey
    private String tipo;
    private String titulo;
    @DynamoDBIndexRangeKey(localSecondaryIndexName = "CriacaoIndex")
    private String descricao;
    @DynamoDBTypeConvertedEnum
    private Prioridade prioridade;
    @DynamoDBTypeConverted(converter = LocalDateTimeToStringConverter.class)
    @DynamoDBAutoGenerated(generator = LocalDateTimeAutoGenerate.class)
    private LocalDateTime criacao;
    @DynamoDBTypeConverted(converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime previsao;
    @DynamoDBTypeConverted(converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime conclusao;
}
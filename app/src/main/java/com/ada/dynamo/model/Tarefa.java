package com.ada.dynamo.model;

import com.ada.dynamo.util.converter.LocalDateTimeToStringConverter;
import com.ada.dynamo.util.converter.PrioridadeToStringConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.LocalDateTime;

@DynamoDbBean
@Setter
public class Tarefa {
    private String id;
    private String tipo;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private LocalDateTime criacao;
    private LocalDateTime previsao;
    private LocalDateTime conclusao;

    @DynamoDbSortKey
    public String getId() {
        return id;
    }

    @DynamoDbPartitionKey
    public String getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    @DynamoDbConvertedBy(PrioridadeToStringConverter.class)
    public Prioridade getPrioridade() {
        return prioridade;
    }

    @DynamoDbConvertedBy(LocalDateTimeToStringConverter.class)
    public LocalDateTime getCriacao() {
        return criacao;
    }

    @DynamoDbConvertedBy(LocalDateTimeToStringConverter.class)
    public LocalDateTime getPrevisao() {
        return previsao;
    }

    @DynamoDbConvertedBy(LocalDateTimeToStringConverter.class)
    public LocalDateTime getConclusao() {
        return conclusao;
    }
}

package com.ada.dynamo.util.converter;

import com.ada.dynamo.model.Prioridade;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.EnumAttributeConverter;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class PrioridadeToStringConverter implements AttributeConverter<Prioridade> {
    private final EnumAttributeConverter<Prioridade> converter;

    public PrioridadeToStringConverter() {
        this.converter = EnumAttributeConverter.create(Prioridade.class);
    }

    @Override
    public AttributeValue transformFrom(Prioridade prioridade) {
        return this.converter.transformFrom(prioridade);
    }

    @Override
    public Prioridade transformTo(AttributeValue attributeValue) {
        return this.converter.transformTo(attributeValue);
    }

    @Override
    public EnhancedType<Prioridade> type() {
        return this.converter.type();
    }

    @Override
    public AttributeValueType attributeValueType() {
        return this.converter.attributeValueType();
    }
}
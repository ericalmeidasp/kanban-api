package com.ada.dynamo.util.converter;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;

public class LocalDateTimeToStringConverter implements AttributeConverter<LocalDateTime> {
    @Override
    public AttributeValue transformFrom(LocalDateTime localDateTime) {
        return AttributeValue.fromS(localDateTime.toString());
    }

    @Override
    public LocalDateTime transformTo(AttributeValue attributeValue) {
        return LocalDateTime.parse(attributeValue.s());
    }

    @Override
    public EnhancedType<LocalDateTime> type() {
        return EnhancedType.of(LocalDateTime.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S;
    }
}
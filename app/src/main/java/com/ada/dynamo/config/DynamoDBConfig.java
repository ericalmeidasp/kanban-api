package com.ada.dynamo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Configuration
public class DynamoDBConfig {
    
    @Bean
    DynamoDbEnhancedClient enhancedClient() {
        return DynamoDbEnhancedClient.create();
    }
}

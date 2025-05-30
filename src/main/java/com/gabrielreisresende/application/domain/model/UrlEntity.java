package com.gabrielreisresende.application.domain.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@Introspected
public class UrlEntity {

    private String id;

    private String url;

    private LocalDateTime expiresAt;

    public Map<String, AttributeValue> toAttributeMap() {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(this.id).build());
        item.put("url", AttributeValue.builder().s(this.url).build());
        item.put("expiresAt", AttributeValue.builder().s(String.valueOf(this.expiresAt)).build());
        return item;
    }
}

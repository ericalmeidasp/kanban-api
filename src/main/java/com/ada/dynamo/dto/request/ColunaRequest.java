package com.ada.dynamo.dto.request;

import lombok.Data;

@Data
public class ColunaRequest {
    private String quadroId;
    private String name;
    private String cor;
    private Integer ordem;
    private Integer limite;
}

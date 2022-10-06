package com.ada.dynamo.dto.response;

import lombok.Data;

@Data
public class ColunaResponse {
    private String id;
    private String name;
    private String cor;
    private Integer ordem;
    private Integer limite;
}

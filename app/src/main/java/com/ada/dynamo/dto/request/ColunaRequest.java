package com.ada.dynamo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ColunaRequest {
    @NotBlank
    private String quadroId;
    @NotBlank
    private String name;
    @NotBlank
    private String cor;
    @NotNull
    private Integer ordem;
    @NotNull
    private Integer limite;
}

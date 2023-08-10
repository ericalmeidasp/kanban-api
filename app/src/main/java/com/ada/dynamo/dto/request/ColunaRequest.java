package com.ada.dynamo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
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

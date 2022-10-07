package com.ada.dynamo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QuadroRequest {
    @NotBlank
    private String name;
}

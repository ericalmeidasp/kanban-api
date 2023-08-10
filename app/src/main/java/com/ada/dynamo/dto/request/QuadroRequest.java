package com.ada.dynamo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class QuadroRequest {
    @NotBlank
    private String name;
}

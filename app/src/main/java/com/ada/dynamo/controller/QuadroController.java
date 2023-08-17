package com.ada.dynamo.controller;

import com.ada.dynamo.dto.request.QuadroRequest;
import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.service.QuadroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kanban/quadro")
@RequiredArgsConstructor
@CrossOrigin
public class QuadroController {
    private final QuadroService service;

    @PostMapping
    public ResponseEntity<QuadroResponse> store(@RequestBody @Valid QuadroRequest quadroRequest) {
        QuadroResponse response = service.adicionar(quadroRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuadroResponse> show(@PathVariable String id) {
        return ResponseEntity.ok(service.exibir(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuadroResponse>> index() {
        return ResponseEntity.ok(service.listar());
    }
}

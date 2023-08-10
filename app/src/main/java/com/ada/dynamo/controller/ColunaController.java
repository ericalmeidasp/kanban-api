package com.ada.dynamo.controller;

import com.ada.dynamo.dto.request.ColunaRequest;
import com.ada.dynamo.dto.response.ColunaResponse;
import com.ada.dynamo.service.ColunaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/coluna")
@RequiredArgsConstructor
@CrossOrigin
public class ColunaController {

    private final ColunaService service;

    @PostMapping
    public ResponseEntity<ColunaResponse> store(@RequestBody @Valid ColunaRequest colunaRequest) {
        return ResponseEntity.ok(service.adicionar(colunaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColunaResponse> show(@PathVariable String id) {
        return ResponseEntity.ok(service.exibir(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ColunaResponse>> index() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/quadro/{quadroId}")
    public ResponseEntity<List<ColunaResponse>> indexQuadro(@PathVariable String quadroId) {
        return ResponseEntity.ok(service.listarPorQuadro(quadroId));
    }
}

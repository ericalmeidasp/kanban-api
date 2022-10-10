package com.ada.dynamo.controller;

import com.ada.dynamo.dto.request.QuadroRequest;
import com.ada.dynamo.dto.response.QuadroResponse;
import com.ada.dynamo.model.Quadro;
import com.ada.dynamo.model.Tarefa;
import com.ada.dynamo.repository.AbstractRepository;
import com.ada.dynamo.repository.QuadroRepository;
import com.ada.dynamo.repository.TarefaRepository;
import com.ada.dynamo.service.QuadroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/todo/quadro")
@RequiredArgsConstructor
public class QuadroController {

    private final QuadroService service;

    @PostMapping
    public ResponseEntity<QuadroResponse> store(@RequestBody @Valid QuadroRequest quadroRequest) {
        return ResponseEntity.ok(service.adicionar(quadroRequest));
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

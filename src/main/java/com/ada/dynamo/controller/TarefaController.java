package com.ada.dynamo.controller;

import com.ada.dynamo.model.Tarefa;
import com.ada.dynamo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaRepository repository;

    @PostMapping
    public ResponseEntity<Tarefa> addTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(repository.save(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> index() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Tarefa>> index(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "5") int size,
                                              @RequestParam String titulo) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(repository.findByTituloContains(titulo, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> show(@PathVariable UUID id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarefa> destroy(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.ada.dynamo.controller;

import com.ada.dynamo.model.Quadro;
import com.ada.dynamo.model.Tarefa;
import com.ada.dynamo.repository.AbstractRepository;
import com.ada.dynamo.repository.QuadroRepository;
import com.ada.dynamo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/quadro")
@RequiredArgsConstructor
public class QuadroController {

    private final QuadroRepository repository;

    @PostMapping
    public ResponseEntity<Quadro> store(@RequestBody Quadro quadro) {
        return ResponseEntity.ok(repository.save(quadro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quadro> show(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id, "quadro"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable String id) {
        repository.deleteById(id,"quadro");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Quadro>> index() {
        return ResponseEntity.ok(repository.findAll("quadro"));
    }
}

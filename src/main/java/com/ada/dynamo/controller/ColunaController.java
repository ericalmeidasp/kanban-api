package com.ada.dynamo.controller;

import com.ada.dynamo.model.Coluna;
import com.ada.dynamo.model.Quadro;
import com.ada.dynamo.repository.ColunaRepository;
import com.ada.dynamo.repository.QuadroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo/coluna")
@RequiredArgsConstructor
public class ColunaController {

    private final ColunaRepository repository;

    @PostMapping("{quadroId}")
    public ResponseEntity<Coluna> store(@PathVariable String quadroId, @RequestBody Coluna coluna) {
        coluna.setId(quadroId + "#" + UUID.randomUUID().toString());
        return ResponseEntity.ok(repository.save(coluna));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coluna> show(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id, "coluna"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable String id) {
        repository.deleteById(id, "coluna");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Coluna>> index() {
        return ResponseEntity.ok(repository.findAll("coluna"));
    }
}

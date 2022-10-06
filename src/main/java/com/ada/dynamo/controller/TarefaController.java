package com.ada.dynamo.controller;

import com.ada.dynamo.dto.request.AlterarColunaTarefaRequest;
import com.ada.dynamo.dto.request.TarefaRequest;
import com.ada.dynamo.dto.response.TarefaResponse;
import com.ada.dynamo.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/todo/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponse> store(@RequestBody TarefaRequest tarefaRequest) {
        return ResponseEntity.ok(service.adicionar(tarefaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponse> show(@PathVariable String id) {
        return ResponseEntity.ok(service.exibir(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponse> update(@RequestBody @Valid TarefaRequest tarefaRequest, @PathVariable String id) {
        return ResponseEntity.ok(service.alterarTarefa(tarefaRequest, id));
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<TarefaResponse> concluirTarefa(@PathVariable String id) {
        return ResponseEntity.ok(service.concluirTarefa(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TarefaResponse> updateTarefaColuna(@RequestBody @Valid AlterarColunaTarefaRequest alterarColunaTarefaRequest, @PathVariable String id) {
        return ResponseEntity.ok(service.alterarColunaTarefa(alterarColunaTarefaRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponse>> index() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/coluna/{colunaId}")
    public ResponseEntity<List<TarefaResponse>> indexColuna(@PathVariable String colunaId) {
        return ResponseEntity.ok(service.listarPorColuna(colunaId));
    }
}

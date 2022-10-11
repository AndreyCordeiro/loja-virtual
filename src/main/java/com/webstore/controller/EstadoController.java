package com.webstore.controller;

import com.webstore.entity.Estado;
import com.webstore.exception.InfoException;
import com.webstore.service.estado.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    public List<Estado> buscarTodos() {
        return estadoService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    public Estado inserir(@RequestBody Estado estado) throws InfoException {
        return estadoService.inserir(estado);
    }

    @PutMapping("/atualizar/{id}")
    public Estado alterar(@PathVariable("id") Long id, @RequestBody Estado estado) throws InfoException {
        return estadoService.alterar(id, estado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

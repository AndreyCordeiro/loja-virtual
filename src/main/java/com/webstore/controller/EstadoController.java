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
    @CrossOrigin("http://localhost:3000")
    public List<Estado> buscarTodos() {
        return estadoService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000")
    public Estado inserir(@RequestBody Estado estado) throws InfoException {
        return estadoService.inserir(estado);
    }

    @PutMapping("/atualizar/{id}")
    @CrossOrigin("http://localhost:3000")
    public Estado alterar(@PathVariable("id") Long id, @RequestBody Estado estado) throws InfoException {
        return estadoService.alterar(id, estado);
    }

    @DeleteMapping("/deletar/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

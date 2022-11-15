package com.webstore.controller;

import com.webstore.entity.Marca;
import com.webstore.exception.InfoException;
import com.webstore.service.marca.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @GetMapping
    @CrossOrigin("http://localhost:3000")
    public List<Marca> buscarTodos() {
        return marcaService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000")
    public Marca inserir(@RequestBody Marca marca) throws InfoException {
        return marcaService.inserir(marca);
    }

    @PutMapping("/atualizar/{id}")
    @CrossOrigin("http://localhost:3000")
    public Marca alterar(@PathVariable("id") Long id, @RequestBody Marca marca) throws InfoException {
        return marcaService.alterar(id, marca);
    }

    @DeleteMapping("/deletar/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

package com.webstore.controller;

import com.webstore.entity.Cidade;
import com.webstore.exception.InfoException;
import com.webstore.service.cidade.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService cidadeService;

    @GetMapping
    public List<Cidade> buscarTodos() {
        return cidadeService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    public Cidade inserir(@RequestBody Cidade cidade) throws InfoException {
        return cidadeService.inserir(cidade);
    }

    @PutMapping("/atualizar/{id}")
    public Cidade alterar(@PathVariable("id") Long id, @RequestBody Cidade cidade) throws InfoException {
        return cidadeService.alterar(id, cidade);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

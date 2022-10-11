package com.webstore.controller;

import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;
import com.webstore.service.pessoa.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    public Pessoa inserir(@RequestBody Pessoa pessoa) throws InfoException {
        return pessoaService.inserir(pessoa);
    }

    @PutMapping("/atualizar/{id}")
    public Pessoa alterar(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) throws InfoException {
        return pessoaService.alterar(id, pessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

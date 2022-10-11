package com.webstore.controller;

import com.webstore.entity.Permissao;
import com.webstore.exception.InfoException;
import com.webstore.service.permissao.PermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
@RequiredArgsConstructor
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping
    public List<Permissao> buscarTodos() {
        return permissaoService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    public Permissao inserir(@RequestBody Permissao permissao) throws InfoException {
        return permissaoService.inserir(permissao);
    }

    @PutMapping("/atualizar/{id}")
    public Permissao alterar(@PathVariable("id") Long id, @RequestBody Permissao permissao) throws InfoException {
        return permissaoService.alterar(id, permissao);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

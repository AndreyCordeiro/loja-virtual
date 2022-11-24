package com.webstore.controller;

import com.webstore.entity.Pessoa;
import com.webstore.service.gerenciamento.GerenciamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gerenciamento")
@RequiredArgsConstructor
public class GerenciamentoController {
    @Autowired
    private GerenciamentoService gerenciamentoService;

    @PostMapping("/senha-codigo")
    @CrossOrigin("http://localhost:3000")
    public String recuperarCodigo(@RequestBody Pessoa pessoa) {
        return gerenciamentoService.solicitarCodigo(pessoa.getEmail());
    }

    @PostMapping("/senha-alterar")
    @CrossOrigin("http://localhost:3000")
    public String alterarSenha(@RequestBody Pessoa pessoa) {
        return gerenciamentoService.alterarSenha(pessoa);
    }
}

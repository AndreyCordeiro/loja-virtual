package com.webstore.controller;

import com.webstore.entity.Imagem;
import com.webstore.exception.InfoException;
import com.webstore.service.imagem.ImagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/imagem")
@RequiredArgsConstructor
public class ImagemController {
    private final ImagemService imagemService;

    @GetMapping
    public List<Imagem> buscarTodos() {
        return imagemService.buscarTodos();
    }

    @GetMapping("/produto/{id}")
    @CrossOrigin("http://localhost:3000")
    public List<Imagem> buscarPorProdutoId(@PathVariable("id") Long id) {
        return imagemService.buscarPorProdutoId(id);
    }

    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000")
    public Imagem inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("arquivo") MultipartFile arquivo) throws InfoException, IOException {
        return imagemService.inserir(idProduto, arquivo);
    }

    @PutMapping("/atualizar/{id}")
    @CrossOrigin("http://localhost:3000")
    public Imagem alterar(@PathVariable("id") Long id, @RequestBody Imagem imagem) throws InfoException {
        return imagemService.alterar(id, imagem);
    }

    @DeleteMapping("/deletar/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        imagemService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

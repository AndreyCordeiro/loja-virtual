package com.webstore.service.produto;

import com.webstore.entity.Produto;
import com.webstore.exception.InfoException;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscarTodos();

    Produto buscarPorId(Long id) throws InfoException;

    Produto inserir(Produto produto) throws InfoException;

    Produto alterar(Long id, Produto produto) throws InfoException;

    void excluir(Long id) throws InfoException;
}

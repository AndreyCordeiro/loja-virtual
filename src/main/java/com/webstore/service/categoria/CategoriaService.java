package com.webstore.service.categoria;

import com.webstore.entity.Categoria;
import com.webstore.exception.InfoException;

import java.util.List;

public interface CategoriaService {
    List<Categoria> buscarTodos();

    Categoria inserir(Categoria categoria) throws InfoException;

    Categoria alterar(Long id, Categoria categoria) throws InfoException;

    void excluir(Long id) throws InfoException;
}

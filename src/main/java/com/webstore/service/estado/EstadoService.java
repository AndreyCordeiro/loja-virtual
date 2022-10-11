package com.webstore.service.estado;

import com.webstore.entity.Estado;
import com.webstore.exception.InfoException;

import java.util.List;

public interface EstadoService {
    List<Estado> buscarTodos();

    Estado inserir(Estado estado) throws InfoException;

    Estado alterar(Long id, Estado estado) throws InfoException;

    void excluir(Long id) throws InfoException;
}

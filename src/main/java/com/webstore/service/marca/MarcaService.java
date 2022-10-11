package com.webstore.service.marca;

import com.webstore.entity.Marca;
import com.webstore.exception.InfoException;

import java.util.List;

public interface MarcaService {
    List<Marca> buscarTodos();

    Marca inserir(Marca marca) throws InfoException;

    Marca alterar(Long id, Marca marca) throws InfoException;

    void excluir(Long id) throws InfoException;
}

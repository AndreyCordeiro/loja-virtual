package com.webstore.service.cidade;

import com.webstore.entity.Cidade;
import com.webstore.exception.InfoException;

import java.util.List;

public interface CidadeService {
    List<Cidade> buscarTodos();

    Cidade inserir(Cidade cidade) throws InfoException;

    Cidade alterar(Long id, Cidade cidade) throws InfoException;

    void excluir(Long id) throws InfoException;
}

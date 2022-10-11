package com.webstore.service.pessoa;

import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;

import java.util.List;

public interface PessoaService {
    List<Pessoa> buscarTodos();

    Pessoa inserir(Pessoa pessoa) throws InfoException;

    Pessoa alterar(Long id, Pessoa pessoa) throws InfoException;

    void excluir(Long id) throws InfoException;
}

package com.webstore.service.permissao;

import com.webstore.entity.Permissao;
import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;

import java.util.List;

public interface PermissaoService {
    List<Permissao> buscarTodos();

    Permissao inserir(Permissao permissao) throws InfoException;

    Permissao alterar(Long id, Permissao permissao) throws InfoException;

    void excluir(Long id) throws InfoException;

    void vincularPessoaPermissaoCliente(Pessoa pessoa) throws InfoException;
}

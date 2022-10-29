package com.webstore.service.gerenciamento;

import com.webstore.entity.Pessoa;

public interface GerenciamentoService {
    String solicitarCodigo(String email);

    String alterarSenha(Pessoa pessoa);
}

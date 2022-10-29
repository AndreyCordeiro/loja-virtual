package com.webstore.service.cliente;

import com.webstore.dto.ClienteRequestDTO;
import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;

public interface ClienteService {
    Pessoa inserir(ClienteRequestDTO clienteRequestDTO) throws InfoException;
}

package com.webstore.controller;

import com.webstore.dto.ClienteRequestDTO;
import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;
import com.webstore.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/cadastrar")
    public Pessoa inserir(@RequestBody ClienteRequestDTO clienteRequestDTO) throws InfoException {
        return clienteService.inserir(clienteRequestDTO);
    }
}

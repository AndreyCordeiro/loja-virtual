package com.webstore.controller;

import com.webstore.dto.ClienteRequestDTO;
import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;
import com.webstore.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/cadastrar")
    @CrossOrigin("http://localhost:3000")
    public Pessoa inserir(@RequestBody ClienteRequestDTO clienteRequestDTO) throws InfoException {
        return clienteService.inserir(clienteRequestDTO);
    }
}

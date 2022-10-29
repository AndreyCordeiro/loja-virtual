package com.webstore.service.cliente;

import com.webstore.dto.ClienteRequestDTO;
import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;
import com.webstore.repository.ClienteRepository;
import com.webstore.service.email.EmailService;
import com.webstore.service.permissao.PermissaoService;
import com.webstore.util.UtilPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PermissaoService permissaoService;

    @Autowired
    private EmailService emailService;

    @Override
    public Pessoa inserir(ClienteRequestDTO clienteRequestDTO) throws InfoException {
        if (UtilPessoa.validarClienteRequestDTO(clienteRequestDTO)) {
            Pessoa pessoa = clienteRepository.save(ClienteRequestDTO.converter(clienteRequestDTO));
            permissaoService.vincularPessoaPermissaoCliente(pessoa);
            emailService.enviarEmailTexto(pessoa.getEmail(), "Seja bem vindo " + pessoa.getNome(), "O seu cadastro na Loja Virtual PW foi realizado com sucesso!");

            return pessoa;
        } else {
            throw new InfoException("Ocorreu um erro ao salvar Cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.webstore.service.pessoa;

import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;
import com.webstore.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa inserir(Pessoa pessoa) throws InfoException {
        return null;
    }

    @Override
    public Pessoa alterar(Long id, Pessoa pessoa) throws InfoException {
        return null;
    }

    @Override
    public void excluir(Long id) throws InfoException {

    }
}

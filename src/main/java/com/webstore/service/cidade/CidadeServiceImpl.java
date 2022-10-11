package com.webstore.service.cidade;

import com.webstore.entity.Cidade;
import com.webstore.exception.InfoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {
    @Override
    public List<Cidade> buscarTodos() {
        return null;
    }

    @Override
    public Cidade inserir(Cidade cidade) throws InfoException {
        return null;
    }

    @Override
    public Cidade alterar(Long id, Cidade cidade) throws InfoException {
        return null;
    }

    @Override
    public void excluir(Long id) throws InfoException {

    }
}

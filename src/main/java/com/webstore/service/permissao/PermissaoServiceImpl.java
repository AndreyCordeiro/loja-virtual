package com.webstore.service.permissao;

import com.webstore.entity.Permissao;
import com.webstore.exception.InfoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoServiceImpl implements PermissaoService {
    @Override
    public List<Permissao> buscarTodos() {
        return null;
    }

    @Override
    public Permissao inserir(Permissao permissao) throws InfoException {
        return null;
    }

    @Override
    public Permissao alterar(Long id, Permissao permissao) throws InfoException {
        return null;
    }

    @Override
    public void excluir(Long id) throws InfoException {

    }
}

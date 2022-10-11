package com.webstore.service.estado;

import com.webstore.entity.Estado;
import com.webstore.exception.InfoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {
    @Override
    public List<Estado> buscarTodos() {
        return null;
    }

    @Override
    public Estado inserir(Estado estado) throws InfoException {
        return null;
    }

    @Override
    public Estado alterar(Long id, Estado estado) throws InfoException {
        return null;
    }

    @Override
    public void excluir(Long id) throws InfoException {

    }
}

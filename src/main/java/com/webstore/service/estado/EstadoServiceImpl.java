package com.webstore.service.estado;

import com.webstore.entity.Estado;
import com.webstore.exception.InfoException;
import com.webstore.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
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

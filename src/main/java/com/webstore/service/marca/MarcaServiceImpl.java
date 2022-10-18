package com.webstore.service.marca;

import com.webstore.entity.Marca;
import com.webstore.exception.InfoException;
import com.webstore.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca inserir(Marca marca) throws InfoException {
        return null;
    }

    @Override
    public Marca alterar(Long id, Marca marca) throws InfoException {
        return null;
    }

    @Override
    public void excluir(Long id) throws InfoException {

    }
}

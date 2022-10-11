package com.webstore.service.marca;

import com.webstore.entity.Marca;
import com.webstore.exception.InfoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Override
    public List<Marca> buscarTodos() {
        return null;
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

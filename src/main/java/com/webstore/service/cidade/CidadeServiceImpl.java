package com.webstore.service.cidade;

import com.webstore.entity.Cidade;
import com.webstore.exception.InfoException;
import com.webstore.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeServiceImpl implements CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
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
        Optional<Cidade> cidade = cidadeRepository.findById(id);

        if (cidade.isPresent()) {
            cidadeRepository.delete(cidade.get());
        } else {
            throw new InfoException("Cidade não encontrada", HttpStatus.NOT_FOUND);
        }
    }
}

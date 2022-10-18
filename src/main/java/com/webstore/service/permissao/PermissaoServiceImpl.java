package com.webstore.service.permissao;

import com.webstore.entity.Permissao;
import com.webstore.exception.InfoException;
import com.webstore.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissaoServiceImpl implements PermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    @Override
    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll();
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
        Optional<Permissao> permissao = permissaoRepository.findById(id);

        if (permissao.isPresent()) {
            permissaoRepository.delete(permissao.get());
        } else {
            throw new InfoException("Permissão não encontrada", HttpStatus.NOT_FOUND);
        }
    }
}

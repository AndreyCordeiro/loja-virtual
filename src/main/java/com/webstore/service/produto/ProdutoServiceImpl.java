package com.webstore.service.produto;

import com.webstore.entity.Produto;
import com.webstore.exception.InfoException;
import com.webstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto inserir(Produto produto) throws InfoException {
        return null;
    }

    @Override
    public Produto alterar(Long id, Produto produto) throws InfoException {
        return null;
    }

    @Override
    public void excluir(Long id) throws InfoException {

    }
}

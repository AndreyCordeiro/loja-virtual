package com.webstore.service.produto;

import com.webstore.entity.Produto;
import com.webstore.exception.InfoException;
import com.webstore.repository.ProdutoRepository;
import com.webstore.util.UtilProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (UtilProduto.validarProduto(produto)) {
            return produtoRepository.save(produto);
        } else {
            throw new InfoException("Ocorreu um erro ao cadastrar produto", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Produto alterar(Long id, Produto produto) throws InfoException {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto produtoBuilder = Produto.builder()
                    .id(id)
                    .nome(produto.getNome() != null ? produto.getNome() : null)
                    .descricao(produto.getDescricao() != null ? produto.getDescricao() : null)
                    .valorCusto(produto.getValorCusto() != null ? produto.getValorCusto() : null)
                    .valorVenda(produto.getValorVenda() != null ? produto.getValorVenda() : null)
                    .marca(produto.getMarca() != null ? produto.getMarca() : null)
                    .categoria(produto.getCategoria() != null ? produto.getCategoria() : null)
                    .build();

            if (UtilProduto.validarProduto(produtoBuilder)) {
                produtoRepository.save(produtoBuilder);
            }
            return produtoBuilder;
        } else {
            throw new InfoException("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void excluir(Long id) throws InfoException {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
        } else {
            throw new InfoException("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}

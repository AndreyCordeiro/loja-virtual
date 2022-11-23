package com.webstore.service.produto;

import com.webstore.entity.Categoria;
import com.webstore.entity.Marca;
import com.webstore.entity.Produto;
import com.webstore.exception.InfoException;
import com.webstore.repository.CategoriaRepository;
import com.webstore.repository.MarcaRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) throws InfoException {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        } else {
            throw new InfoException("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Produto inserir(Produto produto) throws InfoException {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(produto.getCategoria().getId());
        Optional<Marca> marcaOptional = marcaRepository.findById(produto.getMarca().getId());

        if (categoriaOptional.isEmpty()) {
            throw new InfoException("Categoria não encontrada", HttpStatus.BAD_REQUEST);
        } else if (marcaOptional.isEmpty()) {
            throw new InfoException("Marca não encontrada", HttpStatus.BAD_REQUEST);
        } else {
            if (UtilProduto.validarProduto(produto)) {
                produto.setMarca(marcaOptional.get());
                produto.setCategoria(categoriaOptional.get());

                return produtoRepository.save(produto);
            } else {
                throw new InfoException("Ocorreu um erro ao cadastrar produto", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @Override
    public Produto alterar(Long id, Produto produto) throws InfoException {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(produto.getCategoria().getId());
        Optional<Marca> marcaOptional = marcaRepository.findById(produto.getMarca().getId());

        if (categoriaOptional.isEmpty()) {
            throw new InfoException("Categoria não encontrada", HttpStatus.BAD_REQUEST);
        } else if (marcaOptional.isEmpty()) {
            throw new InfoException("Marca não encontrada", HttpStatus.BAD_REQUEST);
        } else {
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

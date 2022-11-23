package com.webstore.service.imagem;

import com.webstore.entity.Imagem;
import com.webstore.exception.InfoException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImagemService {
    List<Imagem> buscarTodos();

    List<Imagem> buscarPorProdutoId(Long id);

    Imagem inserir(Long idProduto, MultipartFile multipartFile) throws IOException, InfoException;

    Imagem alterar(Long id, Imagem imagem) throws InfoException;

    void excluir(Long id) throws InfoException;
}

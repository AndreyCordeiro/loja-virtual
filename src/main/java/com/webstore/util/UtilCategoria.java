package com.webstore.util;

import com.webstore.dto.CategoriaDTO;
import com.webstore.entity.Categoria;
import com.webstore.exception.InfoException;
import org.springframework.http.HttpStatus;

public class UtilCategoria {
    public static Boolean validarCategoria(Categoria categoria) throws InfoException {
        if (categoria.getNome() == null || categoria.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static CategoriaDTO converteCategoria(Categoria categoria) {
        return CategoriaDTO.builder()
                .nome(categoria.getNome())
                .build();
    }
}

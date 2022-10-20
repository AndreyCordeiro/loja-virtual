package com.webstore.util;

import com.webstore.entity.Permissao;
import com.webstore.exception.InfoException;
import org.springframework.http.HttpStatus;

public class UtilPermissao {
    public static Boolean validarPermissao(Permissao permissao) throws InfoException {
        if (permissao.getNome() == null || permissao.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }
}

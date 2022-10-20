package com.webstore.util;

import com.webstore.entity.Cidade;
import com.webstore.exception.InfoException;
import org.springframework.http.HttpStatus;

public class UtilCidade {
    public static Boolean validarCidade(Cidade cidade) throws InfoException {
        if (cidade.getNome() == null || cidade.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (cidade.getEstado() == null) {
            throw new InfoException("MESSAGE.ESTADO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }
}

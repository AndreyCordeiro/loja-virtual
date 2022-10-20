package com.webstore.util;

import com.webstore.entity.Estado;
import com.webstore.exception.InfoException;
import org.springframework.http.HttpStatus;

public class UtilEstado {
    public static Boolean validarEstado(Estado estado) throws InfoException {
        if (estado.getNome() == null || estado.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (estado.getSigla() == null || estado.getSigla().equals("")) {
            throw new InfoException("MESSAGE.SIGLA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }
}

package com.webstore.util;

import com.webstore.entity.Pessoa;
import com.webstore.exception.InfoException;
import org.springframework.http.HttpStatus;

public class UtilPessoa {
    public static Boolean validarPessoa(Pessoa pessoa) throws InfoException {
        if (pessoa.getNome() == null || pessoa.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

}

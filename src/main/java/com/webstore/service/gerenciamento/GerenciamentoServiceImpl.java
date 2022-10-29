package com.webstore.service.gerenciamento;

import com.webstore.entity.Pessoa;
import com.webstore.repository.PessoaRepository;
import com.webstore.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GerenciamentoServiceImpl implements GerenciamentoService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    //TODO FAZER VALIDAÇÃO NOS MÉTODOS
    public String solicitarCodigo(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);

        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());

        pessoaRepository.save(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Código de Recuperação de Senha",
                "Olá, o seu código para recuperação de senha é: " + pessoa.getCodigoRecuperacaoSenha());

        return "Código Enviado!";
    }

    public String alterarSenha(Pessoa pessoa) {
        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());

        if (pessoaBanco != null) {
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());

            if (diferenca.getTime() / 1000 < 900) {
                //TODO criptografar senha
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);

                pessoaRepository.save(pessoaBanco);
                return "Senha alterada com sucesso!";
            } else {
                return "Código expirado, solicite um novo código de recuperação de senha!";
            }
        } else {
            return "Email ou código não encontrado!";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }
}

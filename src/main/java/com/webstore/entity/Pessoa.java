package com.webstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pessoa extends Auditavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "codigo_recuperacao_senha")
    private String codigoRecuperacaoSenha;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_envio_codigo")
    private Date dataEnvioCodigo;

    @Column(name = "senha")
    private String senha;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    public void setPermissaoPessoas(List<PermissaoPessoa> permissaoPessoaList) {
        for (PermissaoPessoa permissaoPessoa : permissaoPessoaList) {
            permissaoPessoa.setPessoa(this);
        }
        this.permissaoPessoas = permissaoPessoaList;
    }
}
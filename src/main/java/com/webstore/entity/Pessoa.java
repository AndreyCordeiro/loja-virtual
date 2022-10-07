package com.webstore.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "senha")
    private String senha;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
}
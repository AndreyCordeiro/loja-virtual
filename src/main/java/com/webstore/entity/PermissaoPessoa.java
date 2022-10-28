package com.webstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "permissao_pessoa")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PermissaoPessoa extends Auditavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_permissao")
    private Permissao permissao;
}

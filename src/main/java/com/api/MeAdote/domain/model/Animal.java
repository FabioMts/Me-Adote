package com.api.MeAdote.domain.model;

import com.api.MeAdote.domain.model.enums.Especie;
import com.api.MeAdote.domain.model.enums.FaixaEtaria;
import com.api.MeAdote.domain.model.enums.Porte;
import com.api.MeAdote.domain.model.enums.Sexo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Especie especie;

    @Column(nullable = false)
    private Porte porte;

    @Column(nullable = false)
    private Sexo sexo;

    @Column(nullable = false)
    private FaixaEtaria faixaEtaria;

    @Column(nullable = false)
    private String nomeTutor;

    @Column(nullable = false)
    private String telefoneTutor;

    @Column
    private String descricao;

    @Column
    private boolean agressivo;

    @Column
    private boolean brincalhao;

    @Column
    private boolean carente;

    @Column
    private boolean castrado;

    @Column
    private boolean sociavel;

    @Column
    private boolean vacinado;

    @Column(name = "caminho_imagem", nullable = false)
    private String caminhoImagem;



}

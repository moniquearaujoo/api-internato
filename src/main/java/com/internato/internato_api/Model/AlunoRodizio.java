package com.internato.internato_api.Model;
import jakarta.persistence.*;

import java.time.LocalDate;

public class AlunoRodizio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Rodizio rodizio;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    private String observacoes;
}



package com.internato.internato_api.Model;

import jakarta.persistence.*;

@Entity
public class Preceptor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
    private String email;
}
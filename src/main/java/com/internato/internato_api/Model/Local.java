package com.internato.internato_api.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    private List<String> especialidades = new ArrayList<>();

    @OneToOne
    private Preceptor preceptor;
}

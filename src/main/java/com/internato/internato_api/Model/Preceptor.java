package com.internato.internato_api.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data  // Gera getters, setters, toString, equals, hashcode
@NoArgsConstructor
@AllArgsConstructor
public class Preceptor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    private String email;
}

package com.internato.internato_api.Model;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Rodizio> rodizios = new ArrayList<>();
}

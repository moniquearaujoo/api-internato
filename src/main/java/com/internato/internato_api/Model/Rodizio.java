package com.internato.internato_api.Model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rodizio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToOne
    private Semestre semestre;

    @ManyToMany
    @JoinTable(
            name = "rodizio_local",
            joinColumns = @JoinColumn(name = "rodizio_id"),
            inverseJoinColumns = @JoinColumn(name = "local_id")
    )
    private List<Local> locais = new ArrayList<>();
}

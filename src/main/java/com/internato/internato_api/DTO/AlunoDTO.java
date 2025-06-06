package com.internato.internato_api.DTO;

import com.internato.internato_api.Model.Aluno;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {
    private Long id;
    private String nome;
    private String matricula;

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
    }

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        aluno.setId(this.id);
        aluno.setNome(this.nome);
        aluno.setMatricula(this.matricula);
        return aluno;
    }
}
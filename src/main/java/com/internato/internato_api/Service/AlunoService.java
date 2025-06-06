package com.internato.internato_api.Service;

import com.internato.internato_api.DTO.AlunoDTO;
import com.internato.internato_api.Model.Aluno;
import com.internato.internato_api.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO salvar(AlunoDTO dto) {
        Aluno aluno = dto.toEntity();
        Aluno salvo = alunoRepository.save(aluno);
        return new AlunoDTO(salvo);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }
}
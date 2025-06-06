package com.internato.internato_api.Service;

import com.internato.internato_api.DTO.SemestreDTO;
import com.internato.internato_api.Model.Semestre;
import com.internato.internato_api.Repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    public List<SemestreDTO> listarTodos() {
        return semestreRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public SemestreDTO salvar(SemestreDTO dto) {
        Semestre semestre = new Semestre();
        semestre.setNome(dto.getNome());
        semestre = semestreRepository.save(semestre);
        return toDTO(semestre);
    }

    public SemestreDTO buscarPorId(Long id) {
        Semestre semestre = semestreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado"));
        return toDTO(semestre);
    }

    private SemestreDTO toDTO(Semestre semestre) {
        SemestreDTO dto = new SemestreDTO();
        dto.setId(semestre.getId());
        dto.setNome(semestre.getNome());
        return dto;
    }
}

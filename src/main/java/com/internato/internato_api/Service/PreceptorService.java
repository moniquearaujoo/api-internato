package com.internato.internato_api.Service;

import com.internato.internato_api.DTO.PreceptorDTO;
import com.internato.internato_api.Model.Preceptor;
import com.internato.internato_api.Repository.PreceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreceptorService {

    @Autowired
    private PreceptorRepository preceptorRepository;

    public Preceptor fromDTO(PreceptorDTO dto) {
        Preceptor preceptor = new Preceptor();
        preceptor.setNome(dto.getNome());
        preceptor.setEspecialidade(dto.getEspecialidade());
        preceptor.setEmail(dto.getEmail());
        return preceptor;
    }

    public Preceptor save(PreceptorDTO dto) {
        Preceptor preceptor = fromDTO(dto);
        return preceptorRepository.save(preceptor);
    }

    public Preceptor update(Long id, PreceptorDTO dto) {
        Preceptor existente = preceptorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preceptor não encontrado"));

        existente.setNome(dto.getNome());
        existente.setEspecialidade(dto.getEspecialidade());
        existente.setEmail(dto.getEmail());

        return preceptorRepository.save(existente);
    }

    public Optional<Preceptor> findById(Long id) {
        return preceptorRepository.findById(id);
    }

    public List<Preceptor> findAll() {
        return preceptorRepository.findAll();
    }

    public void delete(Long id) {
        preceptorRepository.deleteById(id);
    }
}

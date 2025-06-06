package com.internato.internato_api.Service;

import com.internato.internato_api.DTO.LocalDTO;
import com.internato.internato_api.Model.Local;
import com.internato.internato_api.Repository.LocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocalService {

    private final LocalRepository localRepository;

    public Local save(Local local) {
        return localRepository.save(local);
    }

    public Local update(Long id, Local local) {
        Local existente = localRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));
        existente.setNome(local.getNome());
        existente.setEspecialidades(local.getEspecialidades());
        existente.setPreceptor(local.getPreceptor());
        return localRepository.save(existente);
    }

    public Local fromDTO(LocalDTO dto) {
        Local local = new Local();
        local.setNome(dto.getNome());
        local.setEspecialidades(dto.getEspecialidades());
        // Aqui pode adicionar lógica para buscar e setar o preceptor se quiser
        return local;
    }

    public Optional<Local> findById(Long id) {
        return localRepository.findById(id);
    }
}

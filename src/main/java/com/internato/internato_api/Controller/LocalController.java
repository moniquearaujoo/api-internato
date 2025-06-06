package com.internato.internato_api.Controller;

import com.internato.internato_api.DTO.LocalDTO;
import com.internato.internato_api.Model.Local;
import com.internato.internato_api.Service.LocalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locais")
@RequiredArgsConstructor
public class LocalController {

    private final LocalService localService;

    @PostMapping
    public ResponseEntity<Local> create(@Valid @RequestBody LocalDTO dto) {
        Local local = localService.fromDTO(dto);
        return ResponseEntity.ok(localService.save(local));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> update(@PathVariable Long id, @Valid @RequestBody LocalDTO dto) {
        try {
            Local localAtualizado = localService.fromDTO(dto);
            return ResponseEntity.ok(localService.update(id, localAtualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

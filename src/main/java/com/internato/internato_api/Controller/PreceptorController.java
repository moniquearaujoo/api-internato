package com.internato.internato_api.Controller;

import com.internato.internato_api.DTO.PreceptorDTO;
import com.internato.internato_api.Model.Preceptor;
import com.internato.internato_api.Service.PreceptorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preceptores")
public class PreceptorController {

    @Autowired
    private PreceptorService preceptorService;

    @PostMapping
    public ResponseEntity<Preceptor> create(@Valid @RequestBody PreceptorDTO dto) {
        return ResponseEntity.ok(preceptorService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Preceptor> update(@PathVariable Long id, @Valid @RequestBody PreceptorDTO dto) {
        try {
            return ResponseEntity.ok(preceptorService.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Preceptor>> findAll() {
        return ResponseEntity.ok(preceptorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preceptor> findById(@PathVariable Long id) {
        return preceptorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        preceptorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

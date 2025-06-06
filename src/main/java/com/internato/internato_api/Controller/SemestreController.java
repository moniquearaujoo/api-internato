package com.internato.internato_api.Controller;

import com.internato.internato_api.DTO.SemestreDTO;
import com.internato.internato_api.Service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semestres")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @GetMapping
    public List<SemestreDTO> listarTodos() {
        return semestreService.listarTodos();
    }

    @PostMapping
    public SemestreDTO criar(@RequestBody SemestreDTO dto) {
        return semestreService.salvar(dto);
    }

    @GetMapping("/{id}")
    public SemestreDTO buscarPorId(@PathVariable Long id) {
        return semestreService.buscarPorId(id);
    }
}

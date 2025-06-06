package com.internato.internato_api.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class LocalDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Size(min = 1, message = "Deve conter ao menos uma especialidade")
    @Valid
    private List<@NotBlank(message = "Especialidade não pode estar vazia") String> especialidades;

    private Long preceptorId;
}

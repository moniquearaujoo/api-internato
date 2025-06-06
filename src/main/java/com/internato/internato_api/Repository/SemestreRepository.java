package com.internato.internato_api.Repository;

import com.internato.internato_api.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    Optional<Semestre> findByNome(String nome);
}

package com.biblioteca.atividade.repository;

import com.biblioteca.atividade.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

@Query("""
        SELECT new com.biblioteca.atividade.dto.estatisticaEditoraDTO(
            e.nome,
            
        )
        """;
    )

}

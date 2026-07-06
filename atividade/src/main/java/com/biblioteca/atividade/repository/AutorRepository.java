package com.biblioteca.atividade.repository;

import com.biblioteca.atividade.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNomeContaining(String nome);

    @Query("""
                        SELECT DISTINCT a
                        FROM Livro l
                        JOIN l.autores a
                        WHERE l.id = :idLivro
                        """)
        List<Autor> fbLivro(@Param("idLivro") Long idLivro);

}

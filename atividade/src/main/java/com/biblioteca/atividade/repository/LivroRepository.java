package com.biblioteca.atividade.repository;

import com.biblioteca.atividade.model.Autor;
import com.biblioteca.atividade.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTitulo(String titulo);
    List<Livro> findByCategoriaAndPrecoLessThan(String categoria, BigDecimal preco);
    List<Livro> findByPrecoBetween(BigDecimal minPreco, BigDecimal maxPreco);
    List<Livro> findByCategoriaIn(List<String> categorias);
    List<Livro> findByIsbnIsNull();
    List<Livro> findByTituloOrderByTituloAsc(String titulo);
    List<Livro> findDistinctByAutores_Nacionalidade(String nacionalidade);

    @Query("""
            SELECT titulo
            FROM Livro
            WHERE categoria = :categoria
            """)
    List<String> fBCategoria(@Param("categoria") String categoria);

    @Query("""
            SELECT DISTINCT l
            FROM Livro l
            JOIN l.autores a 
            WHERE a.nome= :nomeAutor
            """)
    List<Livro> fBAutor(@Param("nomeAutor") String nomeAutor);

    @Query("""
            SELECT DISTINCT a
            FROM Livro l
            JOIN l.autores a
            WHERE l.id = :idLivro
            """)
    List<Autor> fbLivro(@Param("idLivro") Long idLivro);

}

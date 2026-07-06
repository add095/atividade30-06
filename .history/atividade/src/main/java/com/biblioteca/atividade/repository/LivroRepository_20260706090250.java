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
        /* JPA */
        List<Livro> findByTitulo(String titulo);

        List<Livro> findByCategoriaAndPrecoLessThan(String categoria, BigDecimal preco);

        List<Livro> findByPrecoBetween(BigDecimal minPreco, BigDecimal maxPreco);

        List<Livro> findByCategoriaIn(List<String> categorias);

        List<Livro> findByIsbnIsNull();

        List<Livro> findByTituloOrderByTituloAsc(String titulo);

        List<Livro> findDistinctByAutores_Nacionalidade(String nacionalidade);

        /* JPQL */

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

        @Query("""
                            SELECT AVG(l.preco) AS media
                            FROM  Livro l
                            WHERE l.editora.id = :id
                        """)
        float media(@Param("id") Long idEditora);

        @Query("""
                            SELECT l
                            FROM Livro l
                            WHERE preco > (SELECT AVG(preco) )
                        """)
        List<Livro> fbPreco(@Param("media") BigDecimal media);

        /* Native Query */

        @Query(value = """
                        SELECT *
                        FROM Livro
                        WHERE YEAR(l.data_publicacao) = :ano
                        """, nativeQuery = true)
        List<Livro> fbAno(@Param("ano") int ano);

        @Query(value = """
                        SELECT DISTINCT l.*
                        FROM Livro l
                        INNER JOIN livro_autores la ON l.id = la.livro_id
                        INNER JOIN autor a ON la.autores_id = a.id
                        WHERE a.nacionalidade = :nacionalidade
                        """, nativeQuery = true)
        List<Livro> fbNacionalidade(@Param("nacionalidade") String nacionalidade);

        @Query(value = """
                        SELECT *
                        FROM Livro
                        WHERE LOWER(categoria) = LOWER(:categoria)
                        """, nativeQuery = true)
        List<Livro> fbCategoriaFlex(@Param("categoria") String categoria);

        

}

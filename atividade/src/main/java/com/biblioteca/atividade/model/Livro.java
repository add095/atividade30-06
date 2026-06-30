package com.biblioteca.atividade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Livro")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable=false)
    private String titulo;

    private String isbn;
    private BigDecimal preco;
    private LocalDate dataPublicacao;
    private String categoria;

    @ManyToOne
    private Editora editora;

    @ManyToMany
    @JoinTable(name = "livro_autores")
    private List<Autor> autores;

    public Livro(String titulo, String isbn, BigDecimal preco, LocalDate dataPublicacao, String categoria, Editora editora) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.preco = preco;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.editora = editora;
    }
}

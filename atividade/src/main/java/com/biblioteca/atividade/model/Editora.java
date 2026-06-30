package com.biblioteca.atividade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "editora")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    private List<Livro> livros;

    public Editora(String nome) {
        this.nome = nome;
    }
}

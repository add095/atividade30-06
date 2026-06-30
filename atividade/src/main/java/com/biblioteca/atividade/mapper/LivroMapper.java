package com.biblioteca.atividade.mapper;

import com.biblioteca.atividade.dto.livro.LivroRequestDto;
import com.biblioteca.atividade.dto.livro.LivroResponseDto;
import com.biblioteca.atividade.model.Editora;
import com.biblioteca.atividade.model.Livro;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class LivroMapper {

    public Livro toEntity(LivroRequestDto livro, Editora editora){
        return new Livro(
                livro.titulo(),
                livro.isbn(),
                livro.preco(),
                livro.dataPublicacao(),
                livro.categoria(),
                editora
        );
    }

    public LivroResponseDto toResponse(Livro livro, List<String> nomeAutores){
        return new LivroResponseDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPreco(),
                livro.getDataPublicacao(),
                livro.getCategoria(),
                livro.getEditora().getNome(),
                nomeAutores
        );
    }

}

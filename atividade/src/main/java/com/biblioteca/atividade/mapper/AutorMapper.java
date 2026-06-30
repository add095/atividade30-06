package com.biblioteca.atividade.mapper;

import com.biblioteca.atividade.dto.autor.AutorRequestDto;
import com.biblioteca.atividade.dto.autor.AutorResponseDto;
import com.biblioteca.atividade.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {
    public Autor toEntity(AutorRequestDto autor){
        return new Autor(
                autor.nome(),
                autor.nacionalidade()
        );
    }

    public AutorResponseDto toResponse(Autor autor){
        return new AutorResponseDto(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade()
        );
    }
}

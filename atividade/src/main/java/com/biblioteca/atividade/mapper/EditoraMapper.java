package com.biblioteca.atividade.mapper;

import com.biblioteca.atividade.dto.editora.EditoraRequestDto;
import com.biblioteca.atividade.dto.editora.EditoraResponseDto;
import com.biblioteca.atividade.model.Editora;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditoraMapper {
    public Editora toEntity(EditoraRequestDto editora){
        return new Editora(
                editora.nome()
        );
    }

    public EditoraResponseDto toResponse(Editora editora, List<String> titulosLivros){
        return new EditoraResponseDto(
                editora.getId(),
                editora.getNome(),
                titulosLivros
        );
    }

}

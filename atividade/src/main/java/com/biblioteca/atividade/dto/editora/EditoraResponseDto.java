package com.biblioteca.atividade.dto.editora;

import java.util.List;

public record EditoraResponseDto (
        Long id,
        String nome,
        List<String> titulosLivros
){
}

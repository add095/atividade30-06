package com.biblioteca.atividade.dto.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record LivroResponseDto (
        Long id,
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicacao,
        String categoria,
        String nomeEditora,
        List<String> nomesAutores
){
}

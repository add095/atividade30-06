package com.biblioteca.atividade.dto.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroRequestDto (
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicacao,
        String categoria,
        Long idEditora
){
}

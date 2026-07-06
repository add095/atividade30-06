package com.biblioteca.atividade.dto.livro;

import java.math.BigDecimal;

public record LivroMinimoResponse(
    String nome,
    BigDecimal preco
){
}

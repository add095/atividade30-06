package com.biblioteca.atividade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.atividade.dto.livro.LivroMediaDto;
import com.biblioteca.atividade.dto.livro.LivroRequestDto;
import com.biblioteca.atividade.dto.livro.LivroResponseDto;
import com.biblioteca.atividade.dto.livro.LivroTituloDto;
import com.biblioteca.atividade.mapper.LivroMapper;
import com.biblioteca.atividade.repository.LivroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroService{
    private final LivroRepository lRep;
    private final LivroMapper lMapper;

    public LivroResponseDto criarLivro(LivroRequestDto livroRequestDto){
        return null;
    }

    public List<LivroResponseDto> listarTodos(){
        return null;
    }

    public List<LivroResponseDto> buscarTitulo(){
        return null;
    }

    public List<LivroResponseDto> buscarCategoriaAbaixoPreco(){
        return null;
    }

    public List<LivroResponseDto> buscarPrecoEntre(){
        return null;
    }

    public List<LivroResponseDto> buscarCategoria(){
        return null;
    }

    public List<LivroResponseDto> buscarIsbnNula(){
        return null;
    }

    public List<LivroResponseDto> buscarTitulosOredenadamente(){
        return null;
    }

    public List<LivroResponseDto> buscarLivrosAutoresNacionalidade(){
        return null;
    }

    public List<LivroTituloDto> buscarCategoriaTitulo(){
        return null;
    }

    public List<LivroResponseDto> buscarPorAutor(){
        return null;
    }

    public List<LivroMediaDto> buscarMedia(){
        return null;
    } 

    public List<LivroResponseDto> buscarAno(){
        return null;
    }

    public List<LivroResponseDto> buscarCategoriaFlex(){
        return null;
    }




}

package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.LinkedHashSet;

public record DTORetornoAluno(

        Rm rm,
        TextoValido nome,
        DataNascimento dataNascimento,
        Email email,
        Endereco endereco,
        Celular celular,
        LinkedHashSet<Curso> cursos
) {
}

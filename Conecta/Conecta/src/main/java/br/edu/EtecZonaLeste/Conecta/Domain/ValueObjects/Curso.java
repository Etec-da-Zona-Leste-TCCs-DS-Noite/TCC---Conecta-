package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;

import java.util.List;

public record Curso(

        TextoValido nomeLongoCurso,
        TextoValido nomeCurtoCurso,
        List<Aluno> alunos,
        NumeroNatural numeroDeAulasTotal,
        NumeroNatural numeroDeAulasAtual

) {
}

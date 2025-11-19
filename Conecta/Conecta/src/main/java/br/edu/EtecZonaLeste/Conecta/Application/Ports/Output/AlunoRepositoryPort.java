package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;
import java.util.Optional;

public interface AlunoRepositoryPort {

    void SalvarAluno(Aluno aluno);
    Optional<Aluno> RetornoAlunoPorRm(Rm rm);
    Optional<Aluno> RetornoAlunoPorCpf(Cpf cpf);
    List<Aluno> RetornoAlunos(Integer pages, Integer size);
    List<Aluno> RetornoAlunosPorNome(Integer pages, Integer size, TextoValido nome);
    List<Aluno> RetornoAlunosPorTurma(TextoValido nomeTurma);
}

package br.edu.EtecZonaLeste.Conecta.Application.Ports.Out;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.Optional;

public interface AlunoRepository {

    void SalvarAluno(DTOCadastroAluno dto);
    void AtualizarAluno(Rm rm, DTOAtualizacaoAluno dto);
    void DeletarAluno(Rm rm);
    Optional<DTORetornoAluno> RetornoAlunoPorRm(Rm rm);
    List<DTORetornoAluno> RetornoAlunos(Integer pages, Integer size);
    List<DTORetornoAluno> RetornoAlunosPorNome(Integer pages, Integer size, TextoValido nome);
    List<DTORetornoAluno> RetornoAlunosPorTurma(TextoValido nomeTurma);
}

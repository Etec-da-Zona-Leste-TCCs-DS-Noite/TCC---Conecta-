package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class DeletarAlunoUseCase {

    private final AlunoRepositoryPort repository;

    public DeletarAlunoUseCase(AlunoRepositoryPort repository) {
        this.repository = repository;
    }

    public void DeletarAluno(Rm rm) {
        var retorno = repository.RetornoAlunoPorRm(rm)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        retorno.DeletarUsuario();
        repository.SalvarAluno(retorno);
    }
}

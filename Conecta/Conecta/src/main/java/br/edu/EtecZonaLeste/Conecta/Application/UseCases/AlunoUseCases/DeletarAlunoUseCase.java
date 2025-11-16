package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class DeletarAlunoUseCase {

    private final AlunoRepository repository;

    public DeletarAlunoUseCase(AlunoRepository repository) {
        this.repository = repository;
    }

    public void DeletarAluno(Rm rm) {
        var retorno = repository.RetornoAlunoPorRm(rm)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        retorno.DeletarUsuario();
        repository.SalvarAluno(retorno);
    }
}

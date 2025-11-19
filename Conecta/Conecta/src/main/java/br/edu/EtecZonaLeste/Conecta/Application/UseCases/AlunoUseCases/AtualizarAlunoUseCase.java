package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOAtualizacaoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.AtualizarAlunoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepServicePort;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class AtualizarAlunoUseCase implements AtualizarAlunoPort {

    private final AlunoRepositoryPort repository;
    private final CepServicePort service;

    public AtualizarAlunoUseCase(AlunoRepositoryPort repository, CepServicePort service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void AtualizarAluno(Rm rm, DTOAtualizacaoAluno dto) {
        var retorno = repository.RetornoAlunoPorRm(rm)
                .orElseThrow(() -> new IllegalArgumentException("Aluno n��o encontrado para o RM informado."));
        if (dto.celular() != null) retorno.atualizarCelular(dto.celular());
        if (dto.email() != null) retorno.atualizarEmail(dto.email());
        if (dto.endereco() != null) retorno.atualizarEndereco(service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()));
        if (dto.cursos() != null) retorno.AddCurso(dto.cursos());
        repository.SalvarAluno(retorno);
    }
}

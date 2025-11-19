package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTOAtualizacaoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.AtualizarResponsavelPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepServicePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class AtualizarResponavelUseCase implements AtualizarResponsavelPort {

    private final ProfessorRepositoryPort repository;
    private final CepServicePort service;

    public AtualizarResponavelUseCase(ProfessorRepositoryPort repository, CepServicePort service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void AtualizarResponsavel(Cpf cpf, DTOAtualizacaoResponsavel dto) {
        var retorno = repository.RetornoProfessorPorCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Responsavel nao encontrado"));
        if (dto.email() != null) retorno.atualizarEmail(dto.email());
        if (dto.endereco() != null) retorno.atualizarEndereco(service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()));
        if (dto.celular() != null) retorno.atualizarCelular(dto.celular());
        repository.SalvarProfessor(retorno);
    }
}

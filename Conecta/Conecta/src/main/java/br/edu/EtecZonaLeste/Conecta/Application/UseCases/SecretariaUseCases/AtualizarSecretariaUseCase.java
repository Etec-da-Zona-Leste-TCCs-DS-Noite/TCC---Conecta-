package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTOAtualizacaoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.AtualizarSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepService;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class AtualizarSecretariaUseCase implements AtualizarSecretariaPort {

    private final SecretariaRepository repository;
    private final CepService service;

    public AtualizarSecretariaUseCase(SecretariaRepository repository, CepService service) {
        this.repository = repository;
        this.service = service;
    }


    @Override
    public void AtualizarSecretaria(Cpf cpf, DTOAtualizacaoSecretaria dto) {
        var retorno = repository.RetornoSecretariaPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Usuario não encontrado"));
        if (dto.celular() != null) retorno.atualizarCelular(dto.celular());
        if (dto.email() != null) retorno.atualizarEmail(dto.email());
        if (dto.endereco() != null) retorno.atualizarEndereco(service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()));
        repository.SalvarSecretaria(retorno);
    }
}

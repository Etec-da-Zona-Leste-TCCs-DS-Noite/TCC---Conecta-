package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.RetornoSecretariaPorCpfPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public class RetornoSecretariaPorCpfUseCase implements RetornoSecretariaPorCpfPort {

    private final SecretariaRepositoryPort repository;
    private final SecretariaMapper mapper;

    public RetornoSecretariaPorCpfUseCase(SecretariaRepositoryPort repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DTORetornoSecretaria> RetornoSecretariaPorCpf(Cpf cpf) {
        var retorno = repository.RetornoSecretariaPorCpf(cpf)
                .map(mapper::toDTORetornoSecretaria);
        if (retorno.isEmpty()) throw new DadoInvalidoException("Nenhum professor encontrado com o CPF informado.");
        return retorno;
    }
}

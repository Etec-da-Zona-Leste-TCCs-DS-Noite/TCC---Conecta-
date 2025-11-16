package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.RetornoSecretariaPorNomePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.Optional;

public class RetornoSecretariaPorNomeUseCase implements RetornoSecretariaPorNomePort {

    private final SecretariaRepository repository;
    private final SecretariaMapper mapper;

    public RetornoSecretariaPorNomeUseCase(SecretariaRepository repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DTORetornoSecretaria> RetornoSecretariaPorNome(TextoValido nome) {
        var retorno = repository.RetornoSecretariaPorNome(nome)
                .map(mapper::toDTORetornoSecretaria);
        if (retorno.isEmpty()) throw new DadoInvalidoException("Nenhum professor encontrado com o CPF informado.");
        return retorno;
    }
}

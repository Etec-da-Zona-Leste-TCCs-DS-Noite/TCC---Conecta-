package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.RetornoSecretariaPorNomePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public class RetornoSecretariaPorNomeUseCase implements RetornoSecretariaPorNomePort {

    private final SecretariaRepositoryPort repository;
    private final SecretariaMapper mapper;

    public RetornoSecretariaPorNomeUseCase(SecretariaRepositoryPort repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoSecretaria> RetornoSecretariaPorNome(Integer pages, Integer size, TextoValido nome) {
        List<Secretaria> retornoBruto = repository.RetornoSecretariaPorNome(pages, size, nome);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraSecretariaAtivo(retornoBruto);
    }
}

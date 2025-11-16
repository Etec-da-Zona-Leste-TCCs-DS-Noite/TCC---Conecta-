package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RetornoResponsavelPorCpfPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public class RetornoResponsavelPorCpfUseCase implements RetornoResponsavelPorCpfPort {

    private final ResponsavelRepository repository;
    private final ResponsavelMapper mapper;

    public RetornoResponsavelPorCpfUseCase(ResponsavelRepository repository, ResponsavelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DTORetornoResponsavel> RetornoResponsavelPorCpf(Cpf cpf) {
        var retorno = repository.RetornoResponsavelPorCpf(cpf)
                .map(mapper::toDTORetorno);
        if (retorno.isEmpty()) throw new DadoInvalidoException("Responsável não encontrado para o CPF informado.");
        return retorno;
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RetornoResponsaveisPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoResponsaveisUseCase implements RetornoResponsaveisPort {

    private final ResponsavelRepository repository;
    private final ResponsavelMapper mapper;

    public RetornoResponsaveisUseCase(ResponsavelRepository repository, ResponsavelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoResponsavel> RetornoResponsaveis(Integer pages, Integer size) {
        List<Responsavel> responsaveis = repository.RetornoResponsaveis(pages, size);
        if (responsaveis.isEmpty()) throw new DadoInvalidoException("Nenhum professor encontrado.");
        return responsaveis
                .stream()
                .map(mapper::toDTORetorno)
                .toList();
    }
}

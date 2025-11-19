package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RetornoResponsaveisInativosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoResponsaveisInativosUseCase implements RetornoResponsaveisInativosPort {

    private final ResponsavelRepositoryPort repository;
    private final ResponsavelMapper mapper;

    public RetornoResponsaveisInativosUseCase(ResponsavelRepositoryPort repository, ResponsavelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoResponsavel> RetornoResponsaveisInativos(Integer pages, Integer size) {
        List<Responsavel> retornoBruto = repository.RetornoResponsaveis(pages, size);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraResponsavelInativo(retornoBruto);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RetornoResponsaveisPorNomePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public class RetornoResponsaveisPorNomeUseCase implements RetornoResponsaveisPorNomePort {

    private final ResponsavelRepository repository;
    private final ResponsavelMapper mapper;

    public RetornoResponsaveisPorNomeUseCase(ResponsavelRepository repository, ResponsavelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoResponsavel> RetornoResponsaveisPorNome(Integer pages, Integer size, TextoValido nome) {
        List<Responsavel> retornoBruto = repository.RetornoResponsaveisPorNome(pages, size, nome);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraResponsavelAtivo(retornoBruto);
    }
}

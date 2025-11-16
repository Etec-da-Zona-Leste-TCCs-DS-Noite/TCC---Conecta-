package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RetornoResponsaveisPorFilhosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.LinkedHashSet;
import java.util.List;

public class RetornoResponsaveisPorFilhosUseCase implements RetornoResponsaveisPorFilhosPort {

    private final ResponsavelRepository repository;
    private final AlunoRepository alunoRepository;
    private final ResponsavelMapper mapper;

    public RetornoResponsaveisPorFilhosUseCase(ResponsavelRepository repository, AlunoRepository alunoRepository, ResponsavelMapper mapper) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoResponsavel> RetornoResponsaveisPorFilhos(LinkedHashSet<Rm> rmsFilhos) {
        for (Rm rm : rmsFilhos) {
            alunoRepository.RetornoAlunoPorRm(rm)
                    .orElseThrow(() -> new DadoInvalidoException("Nenhum aluno encontrado com este rm" + rm));
        }
        var responsaveis = repository.RetornoResponsaveisPorFilhos(rmsFilhos);
        return responsaveis
                .stream()
                .map(mapper::toDTORetorno)
                .toList();
    }
}

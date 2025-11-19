package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RetornoResponsaveisPorFilhosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.LinkedHashSet;
import java.util.List;

public class RetornoResponsaveisPorFilhosUseCase implements RetornoResponsaveisPorFilhosPort {

    private final ResponsavelRepositoryPort repository;
    private final AlunoRepositoryPort alunoRepositoryPort;
    private final ResponsavelMapper mapper;

    public RetornoResponsaveisPorFilhosUseCase(ResponsavelRepositoryPort repository, AlunoRepositoryPort alunoRepositoryPort, ResponsavelMapper mapper) {
        this.repository = repository;
        this.alunoRepositoryPort = alunoRepositoryPort;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoResponsavel> RetornoResponsaveisPorFilhos(LinkedHashSet<Rm> rmsFilhos) {
        for (Rm rm : rmsFilhos) {
            alunoRepositoryPort.RetornoAlunoPorRm(rm)
                    .orElseThrow(() -> new DadoInvalidoException("Nenhum aluno encontrado com este rm" + rm));
        }
        List<Responsavel> retornoBruto = repository.RetornoResponsaveisPorFilhos(rmsFilhos);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraResponsavelAtivo(retornoBruto);
    }
}

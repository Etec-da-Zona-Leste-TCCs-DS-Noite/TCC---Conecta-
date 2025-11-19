package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RetornoAlunoPorRmPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.Optional;

public class RetornoAlunoPorRmUseCase implements RetornoAlunoPorRmPort {

    private final AlunoRepositoryPort repository;
    private final AlunoMapper mapper;

    public RetornoAlunoPorRmUseCase(AlunoRepositoryPort repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Optional<DTORetornoAluno> RetornarAlunoPorRm(Rm rm) {
        var retorno = repository.RetornoAlunoPorRm(rm)
                .map(mapper::toDTO);
        if (retorno.isPresent()) return retorno;
        else throw new DadoInvalidoException("Rm do aluno não encontrado.");
    }
}

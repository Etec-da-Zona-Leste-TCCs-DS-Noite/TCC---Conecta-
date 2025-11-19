package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RetornoAlunoPorCpfPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public class RetornoAlunoPorCpfUseCase implements RetornoAlunoPorCpfPort {

    private final AlunoRepositoryPort repository;
    private final AlunoMapper mapper;

    public RetornoAlunoPorCpfUseCase(AlunoRepositoryPort repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DTORetornoAluno> RetornoAlunoPorCpf(Cpf cpf) {
        var retorno = repository.RetornoAlunoPorCpf(cpf)
                .map(mapper::toDTO);
        if (retorno.isPresent()) return retorno;
        else throw new DadoInvalidoException("Cpf do aluno n��o encontrado.");
    }
}

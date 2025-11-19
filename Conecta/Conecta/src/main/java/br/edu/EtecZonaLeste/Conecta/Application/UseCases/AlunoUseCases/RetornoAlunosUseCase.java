package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RetornoAlunosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoAlunosUseCase implements RetornoAlunosPort {

    private final AlunoRepositoryPort repository;
    private final AlunoMapper mapper;

    public RetornoAlunosUseCase(AlunoRepositoryPort repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoAluno> RetornoAlunos(Integer pages, Integer size) {
        List<Aluno> retornoBruto = repository.RetornoAlunos(pages, size);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraAlunoAtivo(retornoBruto);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RetornoAlunosPorTurmaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public class RetornoAlunosPorTurmaUseCase implements RetornoAlunosPorTurmaPort {

    private final AlunoRepositoryPort repository;
    private final AlunoMapper mapper;


    public RetornoAlunosPorTurmaUseCase(AlunoRepositoryPort repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<DTORetornoAluno> RetornoAlunosPorTurma(TextoValido nomeTurma) {
        List<Aluno> retornoBruto = repository.RetornoAlunosPorTurma(nomeTurma);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraAlunoAtivo(retornoBruto);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RetornoAlunosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;

import java.util.List;
import java.util.stream.Collectors;

public class RetornoAlunosUseCase implements RetornoAlunosPort {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;

    public RetornoAlunosUseCase(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoAluno> RetornoAlunos(Integer pages, Integer size) {
        List<Aluno> retornoBruto = repository.RetornoAlunos(pages, size);
        return retornoBruto
                .stream()
                .map(mapper :: toDTO)
                .collect(Collectors.toList());
    }
}

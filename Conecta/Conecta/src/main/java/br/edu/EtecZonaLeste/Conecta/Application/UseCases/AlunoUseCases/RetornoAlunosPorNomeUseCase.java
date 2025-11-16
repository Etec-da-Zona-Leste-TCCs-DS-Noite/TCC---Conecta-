package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RetornoAlunosPorNomePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;
import java.util.stream.Collectors;

public class RetornoAlunosPorNomeUseCase implements RetornoAlunosPorNomePort {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;

    public RetornoAlunosPorNomeUseCase(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoAluno> RetornoAlunosPorNome(Integer pages, Integer size, TextoValido nome) {
        List<Aluno> retornoBruto = repository.RetornoAlunosPorNome(pages, size, nome);
        return retornoBruto
                .stream()
                .map(mapper :: toDTO)
                .collect(Collectors.toList());
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.RetornoProfessoresPorNomePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public class RetornoProfessoresPorNomeUseCase implements RetornoProfessoresPorNomePort {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public RetornoProfessoresPorNomeUseCase(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoProfessor> RetornoProfessoresPorNome(Integer pages, Integer size, TextoValido nome) {
        List<Professor> retornoBruto = repository.RetornoProfessoresPorNome(pages, size, nome);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraProfessorAtivo(retornoBruto);
    }
}

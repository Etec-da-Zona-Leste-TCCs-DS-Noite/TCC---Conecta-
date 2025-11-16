package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.RetornoProfessoresPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoProfessoresUseCase implements RetornoProfessoresPort {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public RetornoProfessoresUseCase(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoProfessor> listarProfessores(Integer pages, Integer size) {
        List<Professor> professores = repository.RetornoProfessores(pages, size);
        if (professores.isEmpty()) throw new DadoInvalidoException("Nenhum professor encontrado.");
        return professores
                .stream()
                .map(mapper::toDTORetorno)
                .toList();
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.RetornoProfessoresInativosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoProfessoresInativosUseCase implements RetornoProfessoresInativosPort {

    private final ProfessorRepositoryPort repository;
    private final ProfessorMapper mapper;

    public RetornoProfessoresInativosUseCase(ProfessorRepositoryPort repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoProfessor> RetornoProfessoresInativos(Integer pages, Integer size) {
        List<Professor> retornoBruto = repository.RetornoProfessores(pages, size);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraProfessorInativo(retornoBruto);
    }
}

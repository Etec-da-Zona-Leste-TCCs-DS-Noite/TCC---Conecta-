package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.RetornoProfessoresInativosPorNomePort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public class RetornoProfessoresInativosPorNomeUseCase implements RetornoProfessoresInativosPorNomePort {

    private final ProfessorRepositoryPort repository;
    private final ProfessorMapper mapper;

    public RetornoProfessoresInativosPorNomeUseCase(ProfessorRepositoryPort repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoProfessor> RetornoProfessoresInativosPorNome(Integer pages, Integer size, TextoValido nome) {
        List<Professor> retornoBruto = repository.RetornoProfessoresPorNome(pages, size, nome);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraProfessorInativo(retornoBruto);
    }
}

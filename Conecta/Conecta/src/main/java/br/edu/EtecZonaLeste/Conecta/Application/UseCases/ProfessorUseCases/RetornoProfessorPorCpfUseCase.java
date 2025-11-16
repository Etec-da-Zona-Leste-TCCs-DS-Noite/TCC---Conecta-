package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.RetornoProfessorPorCpfPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public class RetornoProfessorPorCpfUseCase implements RetornoProfessorPorCpfPort {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public RetornoProfessorPorCpfUseCase(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Optional<DTORetornoProfessor> RetornoProfessorPorCpf(Cpf cpf) {
        var retorno = repository.RetornoProfessorPorCpf(cpf)
                .map(mapper::toDTORetorno);
        if (retorno.isEmpty()) throw new DadoInvalidoException("Nenhum professor encontrado com o CPF informado.");
        return retorno;
    }
}

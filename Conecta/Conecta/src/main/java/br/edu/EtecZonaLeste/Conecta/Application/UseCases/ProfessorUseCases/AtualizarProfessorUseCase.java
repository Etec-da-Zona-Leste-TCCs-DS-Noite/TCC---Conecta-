package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOAtualizacaoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.AtualizarProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class AtualizarProfessorUseCase implements AtualizarProfessorPort {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public AtualizarProfessorUseCase(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void AtualizarProfessor(Cpf cpf, DTOAtualizacaoProfessor dto) {
        var retornoProfessor = repository.RetornoProfessorPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Professor não encontrado para o CPF informado."));
        if (dto.celular() != null) retornoProfessor.atualizarCelular(dto.celular());
        if (dto.endereco() != null) retornoProfessor.atualizarEndereco(dto.endereco());
        if (dto.email() != null) retornoProfessor.atualizarEmail(dto.email());
        if (dto.disciplinas() != null) retornoProfessor.atualizarDisciplinas(dto.disciplinas());
        if (dto.periodos() != null) retornoProfessor.atualizarPeriodos(dto.periodos());
        repository.SalvarProfessor(retornoProfessor);
    }
}

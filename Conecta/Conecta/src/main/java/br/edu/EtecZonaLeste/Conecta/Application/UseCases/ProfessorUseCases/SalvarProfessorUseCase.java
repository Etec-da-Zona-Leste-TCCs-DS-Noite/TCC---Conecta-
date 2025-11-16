package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOCadastroProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.SalvarProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class SalvarProfessorUseCase implements SalvarProfessorPort {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public SalvarProfessorUseCase(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void SalvarProfessor(DTOCadastroProfessor dto) {
        var retorno = (repository.RetornoProfessorPorCpf(dto.cpf()))
                .orElse(null);
        if (retorno != null) {
            throw new DadoInvalidoException("Já existe um professor cadastrado com esse CPF.");
        }
        Professor professorParaSalvar = mapper.toRegister(dto);
        repository.SalvarProfessor(professorParaSalvar);
    }
}

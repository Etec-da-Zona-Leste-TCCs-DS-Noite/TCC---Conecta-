package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOCadastroProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ProfessorMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.SalvarProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnvioValidacaoEmailService;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class SalvarProfessorUseCase implements SalvarProfessorPort {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;
    private final EnvioValidacaoEmailService service;

    public SalvarProfessorUseCase(ProfessorRepository repository, ProfessorMapper mapper, EnvioValidacaoEmailService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }

    @Override
    public void SalvarProfessor(DTOCadastroProfessor dto) {
        var retorno = (repository.RetornoProfessorPorCpf(dto.cpf()))
                .orElse(null);
        if (retorno != null) {
            throw new DadoInvalidoException("Já existe um professor cadastrado com esse CPF.");
        }
        var professorParaSalvar = mapper.toRegister(dto);
        service.EnviarPropostaDeValidacaoEmail(professorParaSalvar.getEmailValidacao().token(), professorParaSalvar.getEmail());
        repository.SalvarProfessor(professorParaSalvar);
    }
}

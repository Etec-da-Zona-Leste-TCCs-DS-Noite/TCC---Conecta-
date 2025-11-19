package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.CanonizarProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;

public class CanonizarProfessorUseCase implements CanonizarProfessorPort {

    private final ProfessorRepositoryPort repository;

    public CanonizarProfessorUseCase(ProfessorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void CanonizarProfessor(Professor professor, String token) {
        if (professor == null || token == null || professor.getEmailValidacao().token() == null ) throw new DadoInvalidoException();
        professor.ValidarEmail(token);
        if (!professor.getEmailValidacao().validado()) throw new FalhaValidacaoException();
        repository.SalvarProfessor(professor);
    }
}

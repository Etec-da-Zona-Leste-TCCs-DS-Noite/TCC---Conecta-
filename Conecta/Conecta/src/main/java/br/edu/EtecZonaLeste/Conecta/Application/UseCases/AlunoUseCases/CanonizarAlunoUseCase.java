package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.CanonizarAlunoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;

public class CanonizarAlunoUseCase implements CanonizarAlunoPort {

    private final AlunoRepositoryPort repository;

    public CanonizarAlunoUseCase(AlunoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void CanonizarAluno(Aluno aluno, String token) {
        if (aluno == null || token == null || aluno.getEmailValidacao().token() == null ) throw new DadoInvalidoException();
        aluno.ValidarEmail(token);
        if (!aluno.getEmailValidacao().validado()) throw new FalhaValidacaoException();
        repository.SalvarAluno(aluno);
    }
}

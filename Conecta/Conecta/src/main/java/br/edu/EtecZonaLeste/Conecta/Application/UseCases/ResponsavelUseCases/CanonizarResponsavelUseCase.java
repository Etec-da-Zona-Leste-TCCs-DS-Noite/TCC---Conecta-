package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.CanonizarResponsavelPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;

public class CanonizarResponsavelUseCase implements CanonizarResponsavelPort {

    private final ResponsavelRepository repository;

    public CanonizarResponsavelUseCase(ResponsavelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void CanonizarResponsavel(Responsavel responsavel, String token) {
        if (responsavel == null || token == null || responsavel.getEmailValidacao().token() == null ) throw new DadoInvalidoException();
        responsavel.ValidarEmail(token);
        if (!responsavel.getEmailValidacao().validado()) throw new FalhaValidacaoException();
        repository.SalvarResponsavel(responsavel);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.CanonizarSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;

public class CanonizarSecretariaUseCase implements CanonizarSecretariaPort {

    private final SecretariaRepository repository;

    public CanonizarSecretariaUseCase(SecretariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void CanonizarSecretaria(Secretaria secretaria, String token) {
        if (secretaria == null || token == null || secretaria.getEmailValidacao().token() == null ) throw new DadoInvalidoException();
        secretaria.ValidarEmail(token);
        if (!secretaria.getEmailValidacao().validado()) throw new FalhaValidacaoException();
        repository.SalvarSecretaria(secretaria);
    }
}

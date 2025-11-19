package br.edu.EtecZonaLeste.Conecta.Application.Services;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.EmailPorts.EnviarEmailAlteracaoSenhaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.EmailServicePort;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public class EnviarEmailAlteracaoSenhaService implements EnviarEmailAlteracaoSenhaPort {

    private final EmailServicePort emailServicePort;

    public EnviarEmailAlteracaoSenhaService(EmailServicePort emailServicePort) {
        this.emailServicePort = emailServicePort;
    }

    @Override
    public void EnviarEmailAlteracaoSenha(Email emailDestino, String token) {
        emailServicePort.EnviarEmailAlteracaoSenha(emailDestino, token);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.Services;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.EmailPorts.EnviarPropostaDeValidacaoEmailPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.EmailServicePort;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public class EnvioValidacaoEmailService implements EnviarPropostaDeValidacaoEmailPort {

    private final String token;
    private final Email email;
    private final EmailServicePort emailServicePort;

    public EnvioValidacaoEmailService(String token, Email email, EmailServicePort emailServicePort) {
        this.token = token;
        this.email = email;
        this.emailServicePort = emailServicePort;
    }

    @Override
    public void EnviarPropostaDeValidacaoEmail(String token, Email email) {
        emailServicePort.EnviarEmailAutenticacao(email, token);
    }
}

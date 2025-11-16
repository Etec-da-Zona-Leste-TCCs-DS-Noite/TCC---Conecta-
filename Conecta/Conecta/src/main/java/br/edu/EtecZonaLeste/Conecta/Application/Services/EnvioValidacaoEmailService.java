package br.edu.EtecZonaLeste.Conecta.Application.Services;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.EmailPorts.EnviarPropostaDeValidacaoEmailPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.EmailService;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public class EnvioValidacaoEmailService implements EnviarPropostaDeValidacaoEmailPort {

    private final String token;
    private final Email email;
    private final EmailService emailService;

    public EnvioValidacaoEmailService(String token, Email email, EmailService emailService) {
        this.token = token;
        this.email = email;
        this.emailService = emailService;
    }

    @Override
    public void EnviarPropostaDeValidacaoEmail(String token, Email email) {
        emailService.EnviarEmailAutenticacao(email, token);
    }
}

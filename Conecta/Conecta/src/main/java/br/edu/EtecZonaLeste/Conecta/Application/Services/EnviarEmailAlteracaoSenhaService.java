package br.edu.EtecZonaLeste.Conecta.Application.Services;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.EmailPorts.EnviarEmailAlteracaoSenhaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.EmailService;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public class EnviarEmailAlteracaoSenhaService implements EnviarEmailAlteracaoSenhaPort {

    private final EmailService emailService;

    public EnviarEmailAlteracaoSenhaService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void EnviarEmailAlteracaoSenha(Email emailDestino, String token) {
        emailService.EnviarEmailAlteracaoSenha(emailDestino, token);
    }
}

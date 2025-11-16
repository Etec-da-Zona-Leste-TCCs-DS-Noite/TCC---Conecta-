package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public interface EmailService {

    void EnviarEmailAutenticacao(Email emailDestino, String token);

    void EnviarEmailAlteracaoSenha(Email emailDestino, String token);
}

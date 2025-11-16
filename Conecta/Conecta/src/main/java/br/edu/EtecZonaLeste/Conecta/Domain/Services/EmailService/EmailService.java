package br.edu.EtecZonaLeste.Conecta.Domain.Services.EmailService;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public interface EmailService {

    boolean ValidarEmail(Email emailDestino, String tokenProposto);

    boolean AlteracaoSenha(Email emailDestino, String tokenProposto);
}

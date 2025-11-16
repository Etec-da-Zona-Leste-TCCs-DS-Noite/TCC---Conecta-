package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.EmailPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.EmailValidacao;

public interface CanonizacaoUsuarioPort {

    EmailValidacao ValidarEmailUsuario(EmailValidacao emailValidacao, String token);
}

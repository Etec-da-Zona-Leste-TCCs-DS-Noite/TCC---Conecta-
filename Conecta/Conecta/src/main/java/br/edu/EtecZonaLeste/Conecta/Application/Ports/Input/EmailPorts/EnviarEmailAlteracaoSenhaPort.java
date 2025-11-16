package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.EmailPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

public interface EnviarEmailAlteracaoSenhaPort {

    void EnviarEmailAlteracaoSenha(Email emailDestino, String token);
}

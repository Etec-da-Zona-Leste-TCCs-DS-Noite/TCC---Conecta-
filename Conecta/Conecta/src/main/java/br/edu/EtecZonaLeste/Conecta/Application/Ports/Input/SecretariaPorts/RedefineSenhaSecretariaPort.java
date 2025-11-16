package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public interface RedefineSenhaSecretariaPort {

    void RedefineSenha(Cpf cpf, String token, Senha novaSenha);
}

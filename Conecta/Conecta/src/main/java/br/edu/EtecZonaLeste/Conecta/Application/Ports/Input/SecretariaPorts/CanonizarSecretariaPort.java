package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;

public interface CanonizarSecretariaPort {

    void CanonizarSecretaria(Secretaria secretaria, String token);
}

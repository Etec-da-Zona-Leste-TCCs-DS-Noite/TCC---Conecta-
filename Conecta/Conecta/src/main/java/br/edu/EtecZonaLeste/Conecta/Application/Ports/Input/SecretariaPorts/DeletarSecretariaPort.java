package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface DeletarSecretariaPort {

    void DeletarSecretaria(Cpf cpf);
}

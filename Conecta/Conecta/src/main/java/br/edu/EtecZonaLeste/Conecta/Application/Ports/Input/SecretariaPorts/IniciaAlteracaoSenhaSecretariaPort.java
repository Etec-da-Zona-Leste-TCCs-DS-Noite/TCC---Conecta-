package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface IniciaAlteracaoSenhaSecretariaPort {

    void init(Cpf cpf);
}

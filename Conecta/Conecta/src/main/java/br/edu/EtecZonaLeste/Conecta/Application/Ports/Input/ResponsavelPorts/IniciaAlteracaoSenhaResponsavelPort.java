package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface IniciaAlteracaoSenhaResponsavelPort {

    void init(Cpf cpf);
}

package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;

public interface CanonizarResponsavelPort {

    void CanonizarResponsavel(Responsavel responsavel, String token);
}

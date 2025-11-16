package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public interface RedefineSenhaResponsavelPort {

    void RedefineSenha(Cpf cpf, String token, Senha novaSenha);
}

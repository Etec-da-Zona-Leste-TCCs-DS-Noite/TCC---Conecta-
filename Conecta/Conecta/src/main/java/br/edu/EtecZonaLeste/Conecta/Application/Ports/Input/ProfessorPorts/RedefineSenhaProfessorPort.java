package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public interface RedefineSenhaProfessorPort {

    void RedefineSenha(Cpf cpf, String token, Senha novaSenha);
}

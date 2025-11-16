package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface IniciaAlteracaoSenhaProfessorPort {

    void init(Cpf cpf);
}

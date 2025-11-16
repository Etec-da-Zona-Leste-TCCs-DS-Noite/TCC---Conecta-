package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface DeletarProfessorPort {

    void DeletarProfessor(Cpf cpf);

}

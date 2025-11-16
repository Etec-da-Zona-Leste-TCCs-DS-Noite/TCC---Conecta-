package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;

public interface CanonizarProfessorPort {

    void CanonizarProfessor(Professor professor, String token);
}

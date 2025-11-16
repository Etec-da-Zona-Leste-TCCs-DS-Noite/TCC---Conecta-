package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public interface RetornoProfessorPorCpfPort {

    Optional<DTORetornoProfessor> RetornoProfessorPorCpf(Cpf cpf);
}

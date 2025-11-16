package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOAtualizacaoProfessor;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface AtualizarProfessorPort {

    void AtualizarProfessor(Cpf cpf, DTOAtualizacaoProfessor dto);
}

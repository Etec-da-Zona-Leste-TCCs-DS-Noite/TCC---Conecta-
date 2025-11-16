package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOCadastroProfessor;

public interface SalvarProfessorPort {

    void SalvarProfessor(DTOCadastroProfessor dto);
}

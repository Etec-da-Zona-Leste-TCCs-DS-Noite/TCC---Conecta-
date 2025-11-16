package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;

import java.util.List;

public interface RetornoProfessoresInativosPort {

    List<DTORetornoProfessor> RetornoProfessoresInativos(Integer pages, Integer size);
}

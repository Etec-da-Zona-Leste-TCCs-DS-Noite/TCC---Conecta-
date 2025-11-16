package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;

import java.util.List;

public interface RetornoProfessoresPort {

    List<DTORetornoProfessor> listarProfessores(Integer pages, Integer size);
}

package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public interface RetornoProfessoresInativosPorNomePort {

    List<DTORetornoProfessor> RetornoProfessoresInativosPorNome(Integer pages, Integer size, TextoValido nome);
}

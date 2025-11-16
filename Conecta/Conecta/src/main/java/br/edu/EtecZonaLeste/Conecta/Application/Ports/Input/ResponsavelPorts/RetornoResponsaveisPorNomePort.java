package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public interface RetornoResponsaveisPorNomePort {

    List<DTORetornoResponsavel> RetornoResponsaveisPorNome(Integer pages, Integer size, TextoValido nome);
}

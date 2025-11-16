package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;

import java.util.List;

public interface RetornoResponsaveisPort {

    List<DTORetornoResponsavel> RetornoResponsaveis(Integer pages, Integer size);
}

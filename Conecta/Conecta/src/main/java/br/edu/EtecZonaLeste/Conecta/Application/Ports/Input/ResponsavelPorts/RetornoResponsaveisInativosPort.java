package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;

import java.util.List;

public interface RetornoResponsaveisInativosPort {

    List<DTORetornoResponsavel> RetornoResponsaveisInativos(Integer pages, Integer size);
}

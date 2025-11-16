package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.LinkedHashSet;
import java.util.List;

public interface RetornoResponsaveisPorFilhosPort {

    List<DTORetornoResponsavel> RetornoResponsaveisPorFilhos(LinkedHashSet<Rm> rmsFilhos);
}

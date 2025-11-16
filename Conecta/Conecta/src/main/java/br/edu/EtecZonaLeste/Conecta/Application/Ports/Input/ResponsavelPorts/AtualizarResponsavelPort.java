package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTOAtualizacaoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface AtualizarResponsavelPort {

    void AtualizarResponsavel(Cpf cpf, DTOAtualizacaoResponsavel dto);
}

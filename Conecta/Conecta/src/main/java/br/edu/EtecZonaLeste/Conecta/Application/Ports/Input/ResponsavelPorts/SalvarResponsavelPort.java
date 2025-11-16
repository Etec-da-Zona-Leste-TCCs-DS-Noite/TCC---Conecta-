package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTOCadastroResponsavel;

public interface SalvarResponsavelPort {

    void SalvarResponsavel(DTOCadastroResponsavel dto);
}

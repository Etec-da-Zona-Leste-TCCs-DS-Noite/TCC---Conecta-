package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.NotePorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso.DTOInsereAviso;

public interface EnviarAvisoPort {

    void InsereAviso(DTOInsereAviso dto);

}

package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;

import java.util.List;

public interface RetornoSecretariaPort {

    List<DTORetornoSecretaria> RetornoSecretaria(Integer pages, Integer size);
}

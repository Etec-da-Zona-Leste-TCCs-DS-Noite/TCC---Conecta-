package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;
import java.util.Optional;

public interface RetornoSecretariaPorNomePort {

    List<DTORetornoSecretaria> RetornoSecretariaPorNome(Integer pages, Integer size, TextoValido nome);
}

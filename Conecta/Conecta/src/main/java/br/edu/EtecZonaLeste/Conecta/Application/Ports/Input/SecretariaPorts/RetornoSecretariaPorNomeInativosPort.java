package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public interface RetornoSecretariaPorNomeInativosPort {

    List<DTORetornoSecretaria> RetornoSecretariaPorNomeInativos(Integer pages, Integer size, TextoValido nome);
}

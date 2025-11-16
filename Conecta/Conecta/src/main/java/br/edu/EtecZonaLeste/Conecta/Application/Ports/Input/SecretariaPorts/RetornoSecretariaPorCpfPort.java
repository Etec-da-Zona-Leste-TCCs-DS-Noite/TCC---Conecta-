package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public interface RetornoSecretariaPorCpfPort {

    Optional<DTORetornoSecretaria> RetornoSecretariaPorCpf(Cpf cpf);
}

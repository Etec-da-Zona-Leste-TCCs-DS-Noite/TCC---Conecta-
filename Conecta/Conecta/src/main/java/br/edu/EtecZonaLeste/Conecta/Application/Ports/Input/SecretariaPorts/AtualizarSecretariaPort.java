package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTOAtualizacaoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public interface AtualizarSecretariaPort {

    void AtualizarSecretaria(Cpf cpf, DTOAtualizacaoSecretaria dto);
}

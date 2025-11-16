package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTOCadastroSecretaria;

public interface SalvarSecretariaPort {

    void SalvarSecretaria(DTOCadastroSecretaria dto);
}

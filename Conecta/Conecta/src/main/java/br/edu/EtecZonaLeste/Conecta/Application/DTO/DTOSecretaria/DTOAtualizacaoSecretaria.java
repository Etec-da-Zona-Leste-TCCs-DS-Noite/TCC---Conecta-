package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Celular;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;

public record DTOAtualizacaoSecretaria(

        Email email,
        DTOEndereco endereco,
        Celular celular
) {
}

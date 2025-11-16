package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cep;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.NumeroEndereco;

public record DTOEndereco(

        Cep cep,
        NumeroEndereco numeroEndereco
) {
}

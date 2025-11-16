package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Celular;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.List;

public record DTOAtualizacaoResponsavel(

        Email email,
        DTOEndereco endereco,
        Celular celular,
        List<Rm> rmsFilhos
) {
}

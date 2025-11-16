package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Celular;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.List;

public record DTOAtualizacaoResponsavel(

        Email email,
        Endereco endereco,
        Celular celular,
        List<Rm> rmsFilhos
) {
}

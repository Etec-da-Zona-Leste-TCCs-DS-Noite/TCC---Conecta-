package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public record DTOInsereAviso(

        Cpf identificadorResponsavelAviso,
        String titulo,
        String conteudo,
        TipoMensageiro tipoDestinatario
) {
}

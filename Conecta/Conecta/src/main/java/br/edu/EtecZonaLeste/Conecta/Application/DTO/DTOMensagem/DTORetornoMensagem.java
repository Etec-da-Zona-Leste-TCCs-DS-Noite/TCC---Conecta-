package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.time.LocalDateTime;

public record DTORetornoMensagem(

        TextoValido nome,
        String mensagem,
        LocalDateTime momentoMensagem
) {
}

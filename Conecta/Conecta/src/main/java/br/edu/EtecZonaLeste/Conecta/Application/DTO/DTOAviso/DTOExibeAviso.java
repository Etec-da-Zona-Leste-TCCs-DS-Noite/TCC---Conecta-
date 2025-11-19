package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso;

import java.time.LocalDateTime;

public record DTOExibeAviso(

        String titulo,
        String conteudo,
        LocalDateTime horaDoAviso
) {
}

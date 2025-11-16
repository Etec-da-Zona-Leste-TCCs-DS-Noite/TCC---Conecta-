package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import java.time.LocalDateTime;

public record IdMensagem(String idMensagem) {

    public IdMensagem(String mensagem, LocalDateTime dataEnvio, String idMensageiro, String idDestinatario) {
        this(mensagem + dataEnvio.toString() + idMensageiro + idDestinatario);
    }
}

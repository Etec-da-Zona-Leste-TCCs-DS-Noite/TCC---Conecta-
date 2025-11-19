package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Note;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.time.LocalDateTime;

public class Aviso {

    private final String titulo;
    private final TextoValido responsavelPeloAviso;
    private final String conteudo;
    private final TipoMensageiro tipoDestinatarios;
    private final LocalDateTime horaDoAviso;

    public Aviso(String titulo, TextoValido responsavelPeloAviso, String conteudo, TipoMensageiro tipoDestinatarios) {
        this.titulo = titulo;
        this.responsavelPeloAviso = responsavelPeloAviso;
        this.conteudo = conteudo;
        this.tipoDestinatarios = tipoDestinatarios;
        this.horaDoAviso = LocalDateTime.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getHoraDoAviso() {
        return horaDoAviso;
    }

    public TipoMensageiro getTipoDestinatarios() {
        return tipoDestinatarios;
    }
}

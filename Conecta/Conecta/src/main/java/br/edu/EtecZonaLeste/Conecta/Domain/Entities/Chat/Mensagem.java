package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.IdMensagem;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.time.LocalDateTime;

public class Mensagem {

    private final IdMensagem id;
    private final String idMensageiro;
    private final String idDestinatario;
    private final TextoValido nome;
    private final String mensagem;
    private final TipoMensageiro tipoRemetente;
    private final LocalDateTime momentoMensagem;
    private final TipoMensageiro tipoDestinatario;

    public Mensagem(String idMensageiro, String idDestinatario, TextoValido nome, String mensagem, TipoMensageiro tipoRemetente, TipoMensageiro tipoDestinatario) {

        this.idMensageiro = idMensageiro;
        this.idDestinatario = idDestinatario;
        this.nome = nome;
        this.mensagem = mensagem;
        this.tipoRemetente = tipoRemetente;
        this.tipoDestinatario = tipoDestinatario;
        this.momentoMensagem = LocalDateTime.now();
        this.id = new IdMensagem(mensagem, momentoMensagem, idMensageiro, idDestinatario);
    }

    public TextoValido getNome() {
        return nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getMomentoMensagem() {
        return momentoMensagem;
    }
}
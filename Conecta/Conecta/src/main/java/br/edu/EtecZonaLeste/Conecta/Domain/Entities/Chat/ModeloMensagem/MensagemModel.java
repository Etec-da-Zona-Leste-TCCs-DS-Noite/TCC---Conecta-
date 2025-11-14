package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.ModeloMensagem;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.time.LocalDateTime;

public abstract class MensagemModel {

    protected final Rm rmRemetente;
    protected final String mensagem;
    protected TipoRemetente tipoRemetente;
    protected final LocalDateTime momentoMensagem;

    public MensagemModel(Rm rmRemetente, String mensagem) {
        this.rmRemetente = rmRemetente;
        this.mensagem = mensagem;
        this.momentoMensagem = LocalDateTime.now();
    }
}

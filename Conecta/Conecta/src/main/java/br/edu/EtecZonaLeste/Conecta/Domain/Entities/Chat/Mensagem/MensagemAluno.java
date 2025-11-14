package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.Mensagem;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.ModeloMensagem.MensagemModel;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.ModeloMensagem.TipoRemetente;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class MensagemAluno extends MensagemModel {
    public MensagemAluno(Rm rmRemetente, String mensagem) {
        super(rmRemetente, mensagem);
        this.tipoRemetente = TipoRemetente.ALUNO;
    }
}

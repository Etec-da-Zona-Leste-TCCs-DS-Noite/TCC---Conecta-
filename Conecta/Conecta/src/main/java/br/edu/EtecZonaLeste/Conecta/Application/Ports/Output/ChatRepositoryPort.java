package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.Mensagem;

import java.util.List;

public interface ChatRepositoryPort {

    void EnviarMensagem(Mensagem mensagem);
    List<Mensagem> RetornarMensagemDaConversa(String idMensageiro, String idDestinatario);
}

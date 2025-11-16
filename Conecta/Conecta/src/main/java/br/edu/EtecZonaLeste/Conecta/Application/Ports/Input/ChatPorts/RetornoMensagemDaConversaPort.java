package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ChatPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem.DTORetornoMensagem;

import java.util.List;

public interface RetornoMensagemDaConversaPort {

    List<DTORetornoMensagem> RetornarMensagemDaConversa(String idMensageiro, String idDestinatario);
}

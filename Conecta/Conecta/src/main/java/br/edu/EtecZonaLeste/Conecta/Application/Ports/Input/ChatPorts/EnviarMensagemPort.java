package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ChatPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem.DTOMensagem;

public interface EnviarMensagemPort {

    void EnviarMensagem(DTOMensagem dto);
}

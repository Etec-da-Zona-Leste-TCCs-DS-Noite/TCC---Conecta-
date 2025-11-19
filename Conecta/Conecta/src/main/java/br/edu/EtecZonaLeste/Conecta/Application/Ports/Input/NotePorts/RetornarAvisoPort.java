package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.NotePorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso.DTOExibeAviso;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;

import java.util.List;

public interface RetornarAvisoPort {

    List<DTOExibeAviso> RetornoDeAvisos(TipoMensageiro tipoLeitura);
}

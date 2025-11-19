package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso.DTOExibeAviso;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Note.Aviso;

import java.util.List;

public class AvisoMapper {

    public DTOExibeAviso toDTOReturn(Aviso aviso){
        return new DTOExibeAviso(
                aviso.getTitulo(),
                aviso.getConteudo(),
                aviso.getHoraDoAviso()
        );
    }
    public List<DTOExibeAviso> Filter(List<Aviso> avisos, TipoMensageiro tipoMensageiro){
        return avisos
                .stream()
                .filter(aviso -> aviso.getTipoDestinatarios() == tipoMensageiro)
                .map(this::toDTOReturn)
                .toList();
    };
}

package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem.DTORetornoMensagem;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.Mensagem;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class ChatMapper {

    public Rm mapStringToRm(String rmString) {
        return new Rm(rmString);
    }
    public String mapRmToString(Rm rm) {
        return rm.toString();
    }
    public Cpf mapStringToCpf(String cpfString) {
        return new Cpf(cpfString);
    }
    public DTORetornoMensagem mapToDTORetornoMensagem(Mensagem mensagem) {
        return new DTORetornoMensagem(
                mensagem.getNome(),
                mensagem.getMensagem(),
                mensagem.getMomentoMensagem()
        );
    }
}

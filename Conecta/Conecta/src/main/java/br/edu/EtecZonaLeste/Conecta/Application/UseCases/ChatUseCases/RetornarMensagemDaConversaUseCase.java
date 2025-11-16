package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ChatUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem.DTORetornoMensagem;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ChatMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ChatPorts.RetornoMensagemDaConversaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ChatRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornarMensagemDaConversaUseCase implements RetornoMensagemDaConversaPort {

    private final ChatRepository repository;
    private final ChatMapper mapper;

    public RetornarMensagemDaConversaUseCase(ChatRepository repository, ChatMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoMensagem> RetornarMensagemDaConversa(String idMensageiro, String idDestinatario) {
        var retorno = repository.RetornarMensagemDaConversa(idMensageiro, idDestinatario);
        if (retorno == null) throw new DadoInvalidoException("Nenhuma mensagem encontrada para essa conversa.");
        List<DTORetornoMensagem> retornoMensagens = retorno
                .stream()
                .map(mapper::mapToDTORetornoMensagem)
                .toList();
        return retornoMensagens;
    }
}

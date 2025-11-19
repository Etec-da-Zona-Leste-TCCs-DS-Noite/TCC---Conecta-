package br.edu.EtecZonaLeste.Conecta.Application.UseCases.NoteUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso.DTOExibeAviso;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AvisoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.NotePorts.RetornarAvisoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.NoteRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;

import java.util.List;

public class RetornarAvisoUseCase implements RetornarAvisoPort {

    private final NoteRepositoryPort repository;
    private final AvisoMapper mapper;

    public RetornarAvisoUseCase(NoteRepositoryPort repository, AvisoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<DTOExibeAviso> RetornoDeAvisos(TipoMensageiro tipoLeitura) {
        var retorno = repository.retornarAvisos();
        return mapper.Filter(retorno, tipoLeitura);
    }
}

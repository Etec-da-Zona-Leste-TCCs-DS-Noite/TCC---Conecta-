package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Note.Aviso;

import java.util.List;

public interface NoteRepositoryPort {

    void SalvarAviso(Aviso aviso);
    List<Aviso> retornarAvisos();
}

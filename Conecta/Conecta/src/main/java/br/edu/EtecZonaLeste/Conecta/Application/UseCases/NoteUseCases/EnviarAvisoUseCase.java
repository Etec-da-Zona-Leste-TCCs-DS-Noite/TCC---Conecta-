package br.edu.EtecZonaLeste.Conecta.Application.UseCases.NoteUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAviso.DTOInsereAviso;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.NotePorts.EnviarAvisoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.NoteRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Note.Aviso;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class EnviarAvisoUseCase implements EnviarAvisoPort {

    private final SecretariaRepositoryPort secretariaRepository;
    private final NoteRepositoryPort repository;

    public EnviarAvisoUseCase(SecretariaRepositoryPort secretariaRepository, NoteRepositoryPort repository) {
        this.secretariaRepository = secretariaRepository;
        this.repository = repository;
    }

    @Override
    public void InsereAviso(DTOInsereAviso dto) {
        if (dto == null) throw new DadoInvalidoException();
        var responsavel = secretariaRepository.RetornoSecretariaPorCpf(dto.identificadorResponsavelAviso())
                .orElseThrow(() -> new DadoInvalidoException());
        Aviso avisoNovo = new Aviso(dto.titulo(), responsavel.getNome(), dto.conteudo(), dto.tipoDestinatario());
        repository.SalvarAviso(avisoNovo);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.RetornoSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoSecretariaUseCase implements RetornoSecretariaPort {

    private final SecretariaRepository repository;
    private final SecretariaMapper mapper;

    public RetornoSecretariaUseCase(SecretariaRepository repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoSecretaria> RetornoSecretaria(Integer pages, Integer size) {
        List<Secretaria> secretaria = repository.RetornoSecretaria(pages, size);
        if (secretaria.isEmpty()) throw new DadoInvalidoException("Nenhum professor encontrado.");
        return secretaria
                .stream()
                .map(mapper::toDTORetornoSecretaria)
                .toList();
    }
}

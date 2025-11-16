package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.RetornaSecretariaInativosPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.util.List;

public class RetornoSecretariaInativosUseCase implements RetornaSecretariaInativosPort {

    private final SecretariaRepository repository;
    private final SecretariaMapper mapper;

    public RetornoSecretariaInativosUseCase(SecretariaRepository repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTORetornoSecretaria> RetornoSecretaria(Integer pages, Integer size) {
        List<Secretaria> retornoBruto = repository.RetornoSecretaria(pages, size);
        if (retornoBruto.isEmpty()) throw new DadoInvalidoException();
        return mapper.FiltraSecretariaInativo(retornoBruto);
    }
}

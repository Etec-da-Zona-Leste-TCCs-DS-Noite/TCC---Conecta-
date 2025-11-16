package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTOCadastroSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.SalvarSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class SalvarSecretariaUseCase implements SalvarSecretariaPort {

    private final SecretariaRepository repository;
    private final SecretariaMapper mapper;

    public SalvarSecretariaUseCase(SecretariaRepository repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void SalvarSecretaria(DTOCadastroSecretaria dto) {
        var retorno = repository.RetornoSecretariaPorCpf(dto.cpf())
                .orElse(null);
        if (retorno != null) throw new DadoInvalidoException("CPF já cadastrado.");
        else {
            var entidade = mapper.toRegister(dto);
            repository.SalvarSecretaria(entidade);
        }
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Mappers.SecretariaMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.DeletarSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class DeletarSecretariaUseCase implements DeletarSecretariaPort {

    private final SecretariaRepository repository;
    private final SecretariaMapper mapper;

    public DeletarSecretariaUseCase(SecretariaRepository repository, SecretariaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void DeletarSecretaria(Cpf cpf) {
        var retorno = repository.RetornoSecretariaPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Usuario não encontrado"));
            retorno.DeletarUsuario();
            repository.SalvarSecretaria(retorno);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.IniciaAlteracaoSenhaSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnviarEmailAlteracaoSenhaService;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class IniciaAlteracaoSenhaSecretariaUseCase implements IniciaAlteracaoSenhaSecretariaPort {

    private final SecretariaRepositoryPort repository;
    private final EnviarEmailAlteracaoSenhaService service;

    public IniciaAlteracaoSenhaSecretariaUseCase(SecretariaRepositoryPort repository, EnviarEmailAlteracaoSenhaService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void init(Cpf cpf) {
        var retorno = repository.RetornoSecretariaPorCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Secretaria nao encontrada para este cpf"));
        retorno.IniciarAlteracaoSenha();
        service.EnviarEmailAlteracaoSenha(retorno.getEmail(), retorno.getAlteraSenha().token());
        repository.SalvarSecretaria(retorno);
    }
}

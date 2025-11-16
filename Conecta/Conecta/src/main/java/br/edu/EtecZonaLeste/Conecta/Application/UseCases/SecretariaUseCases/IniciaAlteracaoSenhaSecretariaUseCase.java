package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.IniciaAlteracaoSenhaSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnviarEmailAlteracaoSenhaService;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class IniciaAlteracaoSenhaSecretariaUseCase implements IniciaAlteracaoSenhaSecretariaPort {

    private final SecretariaRepository repository;
    private final EnviarEmailAlteracaoSenhaService service;

    public IniciaAlteracaoSenhaSecretariaUseCase(SecretariaRepository repository, EnviarEmailAlteracaoSenhaService service) {
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

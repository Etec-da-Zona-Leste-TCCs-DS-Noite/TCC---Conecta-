package br.edu.EtecZonaLeste.Conecta.Application.UseCases.SecretariaUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.SecretariaPorts.RedefineSenhaSecretariaPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.SecretariaRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public class RedefineSenhaSecretariaUseCase implements RedefineSenhaSecretariaPort {

    private final SecretariaRepository repository;

    public RedefineSenhaSecretariaUseCase(SecretariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void RedefineSenha(Cpf cpf, String token, Senha novaSenha) {
        var retorno = repository.RetornoSecretariaPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Usuario nao encontrado"));
        retorno.RedefinirSenha(token, novaSenha);
        repository.SalvarSecretaria(retorno);
    }
}

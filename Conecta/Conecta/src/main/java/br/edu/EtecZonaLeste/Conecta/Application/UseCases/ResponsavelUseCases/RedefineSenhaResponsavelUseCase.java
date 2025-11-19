package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.RedefineSenhaResponsavelPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public class RedefineSenhaResponsavelUseCase implements RedefineSenhaResponsavelPort {

    private final ResponsavelRepositoryPort repository;

    public RedefineSenhaResponsavelUseCase(ResponsavelRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void RedefineSenha(Cpf cpf, String token, Senha novaSenha) {
        var retorno = repository.RetornoResponsavelPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Responsavel nao encontrado"));
        retorno.RedefinirSenha(token, novaSenha);
        repository.SalvarResponsavel(retorno);
    }
}

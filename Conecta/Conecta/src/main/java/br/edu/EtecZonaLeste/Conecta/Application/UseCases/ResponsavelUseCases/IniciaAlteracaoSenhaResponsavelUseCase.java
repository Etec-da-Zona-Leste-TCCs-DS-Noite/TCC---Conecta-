package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.IniciaAlteracaoSenhaResponsavelPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnviarEmailAlteracaoSenhaService;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class IniciaAlteracaoSenhaResponsavelUseCase implements IniciaAlteracaoSenhaResponsavelPort {

    private final ResponsavelRepository repository;
    private final EnviarEmailAlteracaoSenhaService service;

    public IniciaAlteracaoSenhaResponsavelUseCase(ResponsavelRepository repository, EnviarEmailAlteracaoSenhaService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void init(Cpf cpf) {
        var retorno = repository.RetornoResponsavelPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Responsavel nao encontrado para este cpf"));
        retorno.IniciarAlteracaoSenha();
        service.EnviarEmailAlteracaoSenha(retorno.getEmail(), retorno.getAlteraSenha().token());
        repository.SalvarResponsavel(retorno);
    }
}

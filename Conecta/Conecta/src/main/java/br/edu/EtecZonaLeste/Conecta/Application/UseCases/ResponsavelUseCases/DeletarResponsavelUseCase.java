package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.DeletarResponsavelPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class DeletarResponsavelUseCase implements DeletarResponsavelPort {

    private final ResponsavelRepository repository;

    public DeletarResponsavelUseCase(ResponsavelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void DeletarResponsavel(Cpf cpf) {
        var retorno = repository.RetornoResponsavelPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Responsavel nao encontrado para o CPF informado."));
        if (retorno != null) {
            retorno.DeletarUsuario();
            repository.SalvarResponsavel(retorno);
        }
    }
}

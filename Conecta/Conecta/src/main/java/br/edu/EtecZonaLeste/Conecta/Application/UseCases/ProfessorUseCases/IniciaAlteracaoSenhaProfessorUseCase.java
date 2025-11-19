package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.IniciaAlteracaoSenhaProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnviarEmailAlteracaoSenhaService;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class IniciaAlteracaoSenhaProfessorUseCase implements IniciaAlteracaoSenhaProfessorPort {

    private final ProfessorRepositoryPort repository;
    private final EnviarEmailAlteracaoSenhaService service;

    public IniciaAlteracaoSenhaProfessorUseCase(ProfessorRepositoryPort repository, EnviarEmailAlteracaoSenhaService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void init(Cpf cpf) {
        var retorno = repository.RetornoProfessorPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Professor nao encontrado para este cpf"));
        retorno.IniciarAlteracaoSenha();
        service.EnviarEmailAlteracaoSenha(retorno.getEmail(), retorno.getAlteraSenha().token());
        repository.SalvarProfessor(retorno);
    }
}

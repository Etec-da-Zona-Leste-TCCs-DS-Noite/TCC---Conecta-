package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.IniciaAlteracaoSenhaAlunoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnviarEmailAlteracaoSenhaService;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class IniciaAlteracaoSenhaAlunoUseCase implements IniciaAlteracaoSenhaAlunoPort {

    private final AlunoRepository repository;
    private final EnviarEmailAlteracaoSenhaService service;

    public IniciaAlteracaoSenhaAlunoUseCase(AlunoRepository repository, EnviarEmailAlteracaoSenhaService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void init(Rm rm) {
        var retorno = repository.RetornoAlunoPorRm(rm)
                .orElseThrow(() -> new DadoInvalidoException("Aluno nao encontrado para este rm"));
        retorno.IniciarAlteracaoSenha();
        service.EnviarEmailAlteracaoSenha(retorno.getEmail(), retorno.getAlteraSenha().token());
        repository.SalvarAluno(retorno);
    }
}

package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.RedefineSenhaAlunoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public class RedefineSenhaAlunoUseCase implements RedefineSenhaAlunoPort {

    private final AlunoRepository repository;

    public RedefineSenhaAlunoUseCase(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void redefineSenha(Rm rm, String token, Senha novaSenha) {
        var retorno = repository.RetornoAlunoPorRm(rm)
                .orElseThrow(() -> new DadoInvalidoException("Aluno nao encontrado"));
        retorno.RedefinirSenha(token, novaSenha);
        repository.SalvarAluno(retorno);
    }
}

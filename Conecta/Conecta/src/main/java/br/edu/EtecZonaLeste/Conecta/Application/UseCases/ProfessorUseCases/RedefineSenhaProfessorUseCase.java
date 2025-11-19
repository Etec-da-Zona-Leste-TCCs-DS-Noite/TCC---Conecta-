package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.RedefineSenhaProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public class RedefineSenhaProfessorUseCase implements RedefineSenhaProfessorPort {

    private final ProfessorRepositoryPort repository;

    public RedefineSenhaProfessorUseCase(ProfessorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void RedefineSenha(Cpf cpf, String token, Senha novaSenha) {
        var retorno = repository.RetornoProfessorPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Professor nao encontrado"));
        retorno.RedefinirSenha(token, novaSenha);
        repository.SalvarProfessor(retorno);
    }
}

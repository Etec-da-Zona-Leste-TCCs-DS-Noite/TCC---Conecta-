package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ProfessorUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ProfessorPorts.DeletarProfessorPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

public class DeletarProfessorUseCase implements DeletarProfessorPort {

    private final ProfessorRepository repository;

    public DeletarProfessorUseCase(ProfessorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void DeletarProfessor(Cpf cpf) {
        var retorno = repository.RetornoProfessorPorCpf(cpf)
                .orElseThrow(() -> new DadoInvalidoException("Professor não encontrado para o CPF informado."));
        retorno.DeletarUsuario();
        repository.SalvarProfessor(retorno);
    }
}

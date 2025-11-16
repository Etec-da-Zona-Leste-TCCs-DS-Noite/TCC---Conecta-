package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;

public interface CanonizarAlunoPort {

    void CanonizarAluno(Aluno aluno, String token);
}

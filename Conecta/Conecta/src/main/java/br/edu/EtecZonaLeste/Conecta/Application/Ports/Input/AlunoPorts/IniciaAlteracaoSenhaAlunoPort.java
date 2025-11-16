package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Senha;

public interface IniciaAlteracaoSenhaAlunoPort {

    void init(Rm rm);
}

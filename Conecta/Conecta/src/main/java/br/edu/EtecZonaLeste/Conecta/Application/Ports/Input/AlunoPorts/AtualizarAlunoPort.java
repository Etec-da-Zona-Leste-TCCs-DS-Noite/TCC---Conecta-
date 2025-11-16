package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOAtualizacaoAluno;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public interface AtualizarAlunoPort {

    void AtualizarAluno(Rm rm, DTOAtualizacaoAluno dto);
}

package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public interface RetornoAlunoPorCpfPort {

    Optional<DTORetornoAluno> RetornoAlunoPorCpf(Cpf cpf);
}

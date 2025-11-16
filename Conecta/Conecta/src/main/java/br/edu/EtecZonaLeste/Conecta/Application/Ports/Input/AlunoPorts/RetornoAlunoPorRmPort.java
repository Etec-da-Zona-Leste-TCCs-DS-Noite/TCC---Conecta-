package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.Optional;

public interface RetornoAlunoPorRmPort {

    Optional<DTORetornoAluno> RetornarAlunoPorRm(Rm rm);
}

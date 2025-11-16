package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;

public interface RetornoAlunosPorNomeInativosPort {

    List<DTORetornoAluno> RetornoAlunosPorNomeInativos(Integer pages, Integer size, TextoValido nome);
}

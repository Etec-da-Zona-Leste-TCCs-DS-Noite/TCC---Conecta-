package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;

import java.util.List;

public interface RetornoAlunosInativosPort {

    List<DTORetornoAluno> RetornoAlunosInativos(Integer pages, Integer size);
}

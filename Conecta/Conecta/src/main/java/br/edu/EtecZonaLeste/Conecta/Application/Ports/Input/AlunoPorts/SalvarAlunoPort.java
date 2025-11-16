package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOCadastroAluno;

public interface SalvarAlunoPort {

    void SalvarAluno(DTOCadastroAluno dto);
}

package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOCadastroProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;

public class ProfessorMapper {

    public Professor toRegister(DTOCadastroProfessor dto) {
        return new Professor(
                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                dto.endereco(),
                dto.celular(),
                Atividade.ATIVO,
                dto.disciplinas(),
                dto.periodos()
        );
    }
    public DTORetornoProfessor toDTORetorno(Professor professor) {
        return new DTORetornoProfessor(
                professor.getNome(),
                professor.getCpf(),
                professor.getDataNasc(),
                professor.getEmail(),
                professor.getEndereco(),
                professor.getCelular(),
                professor.getDisciplinas(),
                professor.getPeriodos()
        );
    }
}

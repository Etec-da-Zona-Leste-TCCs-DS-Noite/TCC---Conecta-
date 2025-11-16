package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTOCadastroProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepService;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorMapper {

    private final CepService service;

    public ProfessorMapper(CepService service) {
        this.service = service;
    }

    public Professor toRegister(DTOCadastroProfessor dto) {
        return new Professor(
                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()),
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
    public List<DTORetornoProfessor> FiltraProfessorAtivo(List<Professor> professores){
        List<DTORetornoProfessor> retorno = new ArrayList<>();
        for (Professor professor : professores) {
            if (professor.getAtividade() == Atividade.ATIVO){
                retorno.add(
                        toDTORetorno(professor)
                );
            }
        }
        return retorno;
    }
    public List<DTORetornoProfessor>FiltraProfessorInativo(List<Professor> professores){
        List<DTORetornoProfessor> retorno = new ArrayList<>();
        for (Professor professor : professores) {
            if (professor.getAtividade() == Atividade.INATIVO){
                retorno.add(
                        toDTORetorno(professor)
                );
            }
        }
        return retorno;
    }
}

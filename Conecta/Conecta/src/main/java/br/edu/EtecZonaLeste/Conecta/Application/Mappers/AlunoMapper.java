package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOCadastroAluno;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

public class AlunoMapper {

    public Aluno toRegister(DTOCadastroAluno dto){
        return new Aluno(
                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                dto.endereco(),
                dto.celular(),
                Atividade.ATIVO,
                new Rm("Confirmar com Wagner metodo de geração de rm"),
                dto.cursos()
        );
    }
    public DTORetornoAluno toDTO(Aluno aluno){
        return new DTORetornoAluno(
                aluno.getRm(),
                aluno.getNome(),
                aluno.getDataNasc(),
                aluno.getEmail(),
                aluno.getEndereco(),
                aluno.getCelular(),
                aluno.getCursos()
        );
    }
}

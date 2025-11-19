package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOCadastroAluno;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTORetornoAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepServicePort;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno.Aluno;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.util.List;

public class AlunoMapper {

    private final CepServicePort service;

    public AlunoMapper(CepServicePort service) {
        this.service = service;
    }

    public Aluno toRegister(DTOCadastroAluno dto){

        return new Aluno(
                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()),
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

    public List<DTORetornoAluno>FiltraAlunoAtivo(List<Aluno> alunos){
        return alunos
                .stream()
                .filter(aluno -> aluno.getAtividade() == Atividade.ATIVO)
                .map(this::toDTO)
                .toList();
    }

    public List<DTORetornoAluno>FiltraAlunoInativo(List<Aluno> alunos) {
        return alunos
                .stream()
                .filter(aluno -> aluno.getAtividade() == Atividade.INATIVO)
                .map(this::toDTO)
                .toList();
    }
}

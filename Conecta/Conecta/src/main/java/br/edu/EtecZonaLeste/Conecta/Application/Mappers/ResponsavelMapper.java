package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTOCadastroResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepService;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.ArrayList;
import java.util.List;

public class ResponsavelMapper {

    private final AlunoRepository alunoRepository;
    private final CepService service;

    public ResponsavelMapper(AlunoRepository alunoRepository, CepService service) {
        this.alunoRepository = alunoRepository;
        this.service = service;
    }

    public Responsavel toRegister(DTOCadastroResponsavel dto) {
        return new Responsavel(

                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()),
                dto.celular(),
                Atividade.ATIVO,
                dto.rmsFilhos()
        );
    }
    public DTORetornoResponsavel toDTORetorno(Responsavel responsavel) {

        List<TextoValido> nomesFilhos = new ArrayList<>();

        for (var rm : responsavel.getRmsFilhos()) {
            var alunoRetornado = alunoRepository.RetornoAlunoPorRm(rm).get();
            nomesFilhos.add(alunoRetornado.getNome());
        }

        return new DTORetornoResponsavel(

                responsavel.getNome(),
                responsavel.getCpf(),
                responsavel.getDataNasc(),
                responsavel.getEmail(),
                responsavel.getEndereco(),
                responsavel.getCelular(),
                responsavel.getRmsFilhos(),
                nomesFilhos
        );
    }
    public List<DTORetornoResponsavel> FiltraResponsavelAtivo(List<Responsavel> responsaveis){
        List<DTORetornoResponsavel> retorno = new ArrayList<>();
        for (Responsavel responsavel : responsaveis) {
            if (responsavel.getAtividade() == Atividade.ATIVO){
                retorno.add(
                        toDTORetorno(responsavel)
                );
            }
        }
        return retorno;
    }
    public List<DTORetornoResponsavel>FiltraResponsavelInativo(List<Responsavel> responsaveis){
        List<DTORetornoResponsavel> retorno = new ArrayList<>();
        for (Responsavel responsavel : responsaveis) {
            if (responsavel.getAtividade() == Atividade.INATIVO){
                retorno.add(
                        toDTORetorno(responsavel)
                );
            }
        }
        return retorno;
    }
}

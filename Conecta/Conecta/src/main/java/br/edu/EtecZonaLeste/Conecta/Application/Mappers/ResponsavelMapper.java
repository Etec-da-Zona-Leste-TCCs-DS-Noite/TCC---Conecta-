package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTOCadastroResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.ArrayList;
import java.util.List;

public class ResponsavelMapper {

    private final AlunoRepository alunoRepository;

    public ResponsavelMapper(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Responsavel toRegister(DTOCadastroResponsavel dto) {
        return new Responsavel(

                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                dto.endereco(),
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
}

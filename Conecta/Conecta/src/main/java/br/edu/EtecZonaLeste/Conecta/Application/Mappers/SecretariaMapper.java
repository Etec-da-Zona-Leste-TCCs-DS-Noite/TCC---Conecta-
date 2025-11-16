package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor.DTORetornoProfessor;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTOCadastroSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.CepService;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;

import java.util.ArrayList;
import java.util.List;

public class SecretariaMapper {

    private final CepService service;

    public SecretariaMapper(CepService service) {
        this.service = service;
    }

    public Secretaria toRegister(DTOCadastroSecretaria dto){

        return new Secretaria(
                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                service.InsereEndereco(dto.endereco().cep(), dto.endereco().numeroEndereco()),
                dto.celular(),
                Atividade.ATIVO
        );
    }

    public DTORetornoSecretaria toDTORetornoSecretaria(Secretaria secretaria) {

        return new DTORetornoSecretaria(
                secretaria.getNome(),
                secretaria.getCpf(),
                secretaria.getDataNasc(),
                secretaria.getEmail(),
                secretaria.getEndereco(),
                secretaria.getCelular()
        );
    }

    public List<DTORetornoSecretaria> FiltraSecretariaAtivo(List<Secretaria> secretarias){
        List<DTORetornoSecretaria> retorno = new ArrayList<>();
        for (Secretaria secretaria : secretarias) {
            if (secretaria.getAtividade() == Atividade.ATIVO){
                retorno.add(
                        toDTORetornoSecretaria(secretaria)
                );
            }
        }
        return retorno;
    }
    public List<DTORetornoSecretaria>FiltraSecretariaInativo(List<Secretaria> secretarias){
        List<DTORetornoSecretaria> retorno = new ArrayList<>();
        for (Secretaria secretaria : secretarias) {
            if (secretaria.getAtividade() == Atividade.INATIVO){
                retorno.add(
                        toDTORetornoSecretaria(secretaria)
                );
            }
        }
        return retorno;
    }
}

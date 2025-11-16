package br.edu.EtecZonaLeste.Conecta.Application.Mappers;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTOCadastroSecretaria;
import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria.DTORetornoSecretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;

public class SecretariaMapper {

    public Secretaria toRegister(DTOCadastroSecretaria dto){

        return new Secretaria(
                dto.nome(),
                dto.cpf(),
                dto.dataNasc(),
                dto.email(),
                dto.endereco(),
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
}

package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.LinkedHashSet;

public record DTOCadastroResponsavel(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNasc,
        Email email,
        DTOEndereco endereco,
        Celular celular,
        LinkedHashSet<Rm> rmsFilhos
) {
}

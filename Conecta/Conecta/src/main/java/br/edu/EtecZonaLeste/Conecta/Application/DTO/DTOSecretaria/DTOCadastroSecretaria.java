package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public record DTOCadastroSecretaria(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNasc,
        Email email,
        Endereco endereco,
        Celular celular
) {
}

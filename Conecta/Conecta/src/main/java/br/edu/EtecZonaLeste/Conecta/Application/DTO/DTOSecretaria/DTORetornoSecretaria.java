package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOSecretaria;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public record DTORetornoSecretaria(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNascimento,
        Email email,
        Endereco endereco,
        Celular celular
) {
}

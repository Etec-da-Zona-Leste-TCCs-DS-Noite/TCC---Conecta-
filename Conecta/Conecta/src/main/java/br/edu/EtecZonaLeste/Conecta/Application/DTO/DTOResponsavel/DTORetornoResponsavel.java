package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.LinkedHashSet;
import java.util.List;

public record DTORetornoResponsavel(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNascimento,
        Email email,
        Endereco endereco,
        Celular celular,
        LinkedHashSet<Rm> rmsFilhos,
        List<TextoValido> nomesFilhos
) {
}

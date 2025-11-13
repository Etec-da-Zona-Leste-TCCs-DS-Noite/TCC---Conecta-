package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

import java.time.LocalDate;

public record DataNascimento(LocalDate dataNascimento) {

public DataNascimento(LocalDate dataNascimento) {
    if (dataNascimento != null && dataNascimento.isBefore(LocalDate.now().minusYears(18)) && dataNascimento.isAfter(dataNascimento.minusYears(100))){
        this.dataNascimento = dataNascimento;
    } else throw new DadoInvalidoException("Data de nascimento invalida");
}
}
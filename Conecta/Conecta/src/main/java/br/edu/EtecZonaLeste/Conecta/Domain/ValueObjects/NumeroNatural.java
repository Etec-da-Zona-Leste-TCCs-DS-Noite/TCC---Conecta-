package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public record NumeroNatural(Integer numero) {

    public NumeroNatural(Integer numero) {
        if (numero != null && numero >= 0) this.numero = numero;
        else throw new DadoInvalidoException("Número inválido ou inexistente");
    }
}

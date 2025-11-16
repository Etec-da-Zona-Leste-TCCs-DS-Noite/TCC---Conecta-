package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public record NumeroEndereco(String numero) {

    public NumeroEndereco(String numero) {
        if (numero.matches("^\\d+(?:[\\/\\-]\\d+)?(?:\\s*[A-Za-z])?$\n")) this.numero = numero;
        else throw new DadoInvalidoException("Numero invalido");
    }
}

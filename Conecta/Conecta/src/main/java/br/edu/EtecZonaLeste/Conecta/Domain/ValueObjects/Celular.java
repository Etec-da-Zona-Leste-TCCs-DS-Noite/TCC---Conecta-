package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public record Celular(String celular) {

    public Celular(String celular) {
        if (celular != null && celular.matches("^[1-9]{2}[9][0-9]{8}$")) this.celular = celular;
        else throw new DadoInvalidoException("Celular invalido");
    }
}

package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public record Cep(String cep) {

    public Cep(String cep) {
        if (cep.matches("^[0-9]{8}$")) this.cep = cep;
        else throw new DadoInvalidoException("CEP invalido");
    }
}

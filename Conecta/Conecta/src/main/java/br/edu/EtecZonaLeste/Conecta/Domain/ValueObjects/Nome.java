package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public record Nome(String nome) {

    public Nome(String nome) {
        if (nome != null && nome.matches("^[\\p{L} ]{2,250}+$")) this.nome = nome;
        else throw new DadoInvalidoException("Nome invalido");
    }
}

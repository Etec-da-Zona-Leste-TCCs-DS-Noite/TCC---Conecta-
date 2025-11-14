package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public record TextoValido(String nome) {

    public TextoValido(String nome) {
        if (nome != null && nome.matches("^[\\p{L} ]{1,250}+$")) this.nome = nome;
        else throw new DadoInvalidoException("Nome invalido");
    }
}

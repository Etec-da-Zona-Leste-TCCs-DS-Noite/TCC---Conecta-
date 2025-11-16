package br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions;

public class ConteudoInapropriadoException extends RuntimeException {
    public ConteudoInapropriadoException() {
        super("Conteudo inapropriado para envio");
    }
}

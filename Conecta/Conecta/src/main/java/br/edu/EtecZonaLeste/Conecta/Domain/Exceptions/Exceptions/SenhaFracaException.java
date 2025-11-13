package br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions;

public class SenhaFracaException extends RuntimeException {
    public SenhaFracaException() {
        super("Senha fraca");
    }
}

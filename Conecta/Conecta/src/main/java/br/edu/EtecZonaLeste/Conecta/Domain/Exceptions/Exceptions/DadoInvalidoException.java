package br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions;

public class DadoInvalidoException extends RuntimeException {
    public DadoInvalidoException(String message) {
        super(message);
    }
    public DadoInvalidoException() {
        super("Erro de processamento");
    }
}

package br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions;

public class FalhaValidacaoException extends RuntimeException {
    public FalhaValidacaoException(String message) {
        super(message);
    }

    public FalhaValidacaoException() {
        super("Falha na validacao");
    }
}

package br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException() {
        super("Usuario nao encontrado");
    }
}

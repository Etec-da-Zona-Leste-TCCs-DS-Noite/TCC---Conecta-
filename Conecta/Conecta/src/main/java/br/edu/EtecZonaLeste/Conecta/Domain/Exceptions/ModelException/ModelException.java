package br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.ModelException;

import java.time.Instant;

public class ModelException {

    private Instant instanteDaExcecao;
    private String mensagem;

    public ModelException(String mensagem) {
        this.mensagem = mensagem;
        this.instanteDaExcecao = Instant.now();
    }
}

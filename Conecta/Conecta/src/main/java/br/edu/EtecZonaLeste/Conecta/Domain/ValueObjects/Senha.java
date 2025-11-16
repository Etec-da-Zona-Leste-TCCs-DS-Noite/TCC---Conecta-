package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.SenhaFracaException;

public record Senha(String senha) {

    public Senha(String senha) {
        if (senha != null && senha.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$")) this.senha = senha;
        if (!(senha.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$") && senha.isEmpty())); throw new SenhaFracaException();
    }
}

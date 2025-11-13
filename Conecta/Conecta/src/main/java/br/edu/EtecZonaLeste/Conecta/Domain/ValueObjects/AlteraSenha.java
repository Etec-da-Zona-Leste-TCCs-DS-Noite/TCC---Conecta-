package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlteraSenha(

        String token,
        LocalDateTime expiracaoToken
) {
    public static AlteraSenha Iniciar() {
        String token = UUID.randomUUID().toString();
        LocalDateTime expiracaoToken = LocalDateTime.now().plusHours(1);
        return new AlteraSenha(token, expiracaoToken);
    }

    public boolean Validar(String tokenProposto){
        if (tokenProposto.equals(this.token) && LocalDateTime.now().isBefore(this.expiracaoToken)){
            return true;
        }
        else  {
            throw new FalhaValidacaoException();
        }
    }
    public AlteraSenha Zerar(){
        return new AlteraSenha(null, null);
    }
}

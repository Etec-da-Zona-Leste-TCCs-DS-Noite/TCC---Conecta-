package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;

import java.util.UUID;

public record EmailValidacao(

        String token,
        boolean validado
) {

    public static EmailValidacao Iniciar(){

        String token = UUID.randomUUID().toString();
        return new EmailValidacao(token,false);
    }

    public EmailValidacao Confirmar(String tokenProposto){

        if (this.validado){
            return this;
        }
        if (tokenProposto.equals(this.token)){
            return new EmailValidacao(null,true);
        } else {
            throw new FalhaValidacaoException();
        }

    }
}

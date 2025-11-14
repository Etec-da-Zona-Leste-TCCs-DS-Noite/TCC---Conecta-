package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.Secretaria;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario.FuncionarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class Secretaria extends FuncionarioGeral {

    public Secretaria(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, EmailValidacao emailValidacao, AlteraSenha alteraSenha, Atividade atividade, Rf rf) {
        super(nome, cpf, dataNasc, email, endereco, celular, emailValidacao, alteraSenha, atividade, rf);
    }
}

package br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseFuncionario.FuncionarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class Secretaria extends FuncionarioGeral {

    public Secretaria(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, Atividade atividade) {
        super(nome, cpf, dataNasc, email, endereco, celular, atividade);
    }
}

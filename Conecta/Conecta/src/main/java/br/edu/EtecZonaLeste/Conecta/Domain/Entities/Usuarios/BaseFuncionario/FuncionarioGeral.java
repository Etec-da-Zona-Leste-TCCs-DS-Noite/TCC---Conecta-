package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.BaseDeUsuarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class FuncionarioGeral extends BaseDeUsuarioGeral {

    private final Rf rf;
    private Cargo cargo;

    public FuncionarioGeral(Nome nome, Cpf cpf, TipoUsuario tipoUsuario, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, EmailValidacao emailValidacao, AlteraSenha alteraSenha, Atividade atividade, Rf rf, Cargo cargo) {
        super(nome, cpf, tipoUsuario, dataNasc, email, endereco, celular, emailValidacao, alteraSenha, atividade);
        this.rf = rf;
        this.cargo = cargo;
    }
}

package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.BaseDeUsuarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class FuncionarioGeral extends BaseDeUsuarioGeral {

    protected final Rf rf;
    protected Cargo cargo;

    public FuncionarioGeral(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, EmailValidacao emailValidacao, AlteraSenha alteraSenha, Atividade atividade, Rf rf) {
        super(nome, cpf, dataNasc, email, endereco, celular, emailValidacao, alteraSenha, atividade);
        this.rf = rf;
        this.tipoUsuario = TipoUsuario.FUNCIONARIO;
    }
}

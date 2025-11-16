package br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseFuncionario;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.BaseUsuarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class FuncionarioGeral extends BaseUsuarioGeral {

    protected Cargo cargo;

    public FuncionarioGeral(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, Atividade atividade) {
        super(nome, cpf, dataNasc, email, endereco, celular, atividade);
        this.tipoUsuario = TipoUsuario.FUNCIONARIO;
    }
}

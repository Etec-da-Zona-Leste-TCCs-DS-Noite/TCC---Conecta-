package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.Professor;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario.Cargo;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario.FuncionarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class Professor extends FuncionarioGeral {

    private List<Disciplina> disciplinas;
    private List<Periodo> periodos;

    public Professor(Nome nome, Cpf cpf, TipoUsuario tipoUsuario, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, EmailValidacao emailValidacao, AlteraSenha alteraSenha, Atividade atividade, Rf rf, Cargo cargo, List<Disciplina> disciplinas) {
        super(nome, cpf, tipoUsuario, dataNasc, email, endereco, celular, emailValidacao, alteraSenha, atividade, rf, cargo);
        this.disciplinas = disciplinas;
        this.periodos = periodos;
    }
}

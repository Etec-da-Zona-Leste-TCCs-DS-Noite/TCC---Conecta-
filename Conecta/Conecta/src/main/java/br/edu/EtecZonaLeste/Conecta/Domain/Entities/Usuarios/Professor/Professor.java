package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.Professor;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario.Cargo;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseFuncionario.FuncionarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.List;

public class Professor extends FuncionarioGeral {

    private List<Disciplina> disciplinas;
    private List<Periodo> periodos;

    public Professor(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, EmailValidacao emailValidacao, AlteraSenha alteraSenha, Atividade atividade, Rf rf, List<Disciplina> disciplinas) {
        super(nome, cpf, dataNasc, email, endereco, celular, emailValidacao, alteraSenha, atividade, rf);
        this.disciplinas = disciplinas;
        this.cargo = Cargo.PROFESSOR;
        this.periodos = periodos;
    }
}

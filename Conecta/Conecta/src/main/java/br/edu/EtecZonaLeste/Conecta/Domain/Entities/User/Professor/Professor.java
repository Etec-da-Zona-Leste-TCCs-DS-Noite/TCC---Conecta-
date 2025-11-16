package br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseFuncionario.Cargo;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseFuncionario.FuncionarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.List;

public class Professor extends FuncionarioGeral {

    private List<Disciplina> disciplinas;
    private List<Periodo> periodos;

    public Professor(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, Atividade atividade, List<Disciplina> disciplinas, List<Periodo> periodos) {
        super(nome, cpf, dataNasc, email, endereco, celular, atividade);
        this.disciplinas = disciplinas;
        this.cargo = Cargo.PROFESSOR;
        this.periodos = periodos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void atualizarDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void atualizarPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }
}

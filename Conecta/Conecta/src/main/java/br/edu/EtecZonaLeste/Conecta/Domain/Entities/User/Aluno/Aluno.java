package br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Aluno;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.BaseUsuarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.LinkedHashSet;
import java.util.List;

public class Aluno extends BaseUsuarioGeral {

    private final Rm rm;
    private LinkedHashSet<Curso> cursos;

    public Aluno(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, Atividade atividade, Rm rm, LinkedHashSet<Curso> cursos) {
        super(nome, cpf, dataNasc, email, endereco, celular, atividade);
        this.rm = rm;
        this.tipoUsuario = TipoUsuario.ALUNO;
        this.cursos = cursos;
    }

    public void AddCurso(LinkedHashSet<Curso> cursos) {
        if (cursos.contains(this.cursos) && cursos == null) throw new DadoInvalidoException("Curso inválido ou já cadastrado para o aluno.");
        this.cursos.addAll(cursos);
    }

    public LinkedHashSet<Curso> getCursos() {
        return cursos;
    }

    public Rm getRm() {
        return rm;
    }
}

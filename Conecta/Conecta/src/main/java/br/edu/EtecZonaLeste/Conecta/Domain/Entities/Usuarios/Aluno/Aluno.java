package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.Aluno;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.BaseDeUsuarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuarioGeral.TipoUsuario;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public class Aluno extends BaseDeUsuarioGeral {

    private final Rm rm;
    private Curso curso;
    private Periodo periodo;

    public Aluno(Nome nome, Cpf cpf, TipoUsuario tipoUsuario, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, EmailValidacao emailValidacao, AlteraSenha alteraSenha, Atividade atividade, Rm rm, Curso curso, Periodo periodo) {
        super(nome, cpf, tipoUsuario, dataNasc, email, endereco, celular, emailValidacao, alteraSenha, atividade);
        this.rm = rm;
        this.curso = curso;
        this.periodo = periodo;
    }
}

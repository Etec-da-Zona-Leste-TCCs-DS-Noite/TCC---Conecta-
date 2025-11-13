package br.edu.EtecZonaLeste.Conecta.Domain.Entities.Usuarios.BaseUsuario;

public abstract class BaseDeUsuario {

    protected final Nome nome;
    protected final Cpf cpf;
    protected Email email;
    protected final DataNascimento dataNasc;
    protected Endereco endereco;
    protected Telefone telefone;
    protected ValidaEmail validaEmail;
    protected AlteraSenha alteraSenha;
    protected final TipoUsuario tipoUsuario;
    protected Atividade atividade;

    public BaseDeUsuario(Nome nome, Cpf cpf, TipoUsuario tipoUsuario, DataNascimento dataNasc, Email email, Endereco endereco, Telefone telefone, ValidaEmail validaEmail, AlteraSenha alteraSenha, Atividade atividade) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoUsuario = tipoUsuario;
        this.dataNasc = dataNasc;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.validaEmail = validaEmail;
        this.alteraSenha = alteraSenha;
        this.atividade = atividade;
    }

    public void IniciarAlteracaoSenha(){}
    public void RefefinirSenha(){}
    public String GetAlterador(){}

    public Nome getNome() {
        return nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public DataNascimento getDataNasc() {
        return dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public ValidaEmail getValidaEmail() {
        return validaEmail;
    }

    public AlteraSenha getAlteraSenha() {
        return alteraSenha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public Atividade getAtividade() {
        return atividade;
    }
}

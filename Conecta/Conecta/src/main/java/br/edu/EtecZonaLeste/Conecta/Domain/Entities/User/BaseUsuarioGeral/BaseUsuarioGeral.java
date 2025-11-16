package br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral;

import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.FalhaValidacaoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

public abstract class BaseUsuarioGeral {

    protected final TextoValido nome;
    protected final Cpf cpf;
    protected Email email;
    protected Senha senhaBruta;
    protected final DataNascimento dataNasc;
    protected Endereco endereco;
    protected Celular celular;
    protected EmailValidacao emailValidacao;
    protected AlteraSenha alteraSenha;
    protected TipoUsuario tipoUsuario;
    protected Atividade atividade;

    public BaseUsuarioGeral(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Senha senhaBruta, Endereco endereco, Celular celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senhaBruta = senhaBruta;
        this.endereco = endereco;
        this.celular = celular;
        this.atividade = Atividade.INATIVO;
        this.emailValidacao = EmailValidacao.Iniciar();
        this.alteraSenha = null;
    }

    public void ValidarEmail(String tokenProposto){
        if (tokenProposto == null) throw new FalhaValidacaoException();
        this.emailValidacao = this.emailValidacao.Confirmar(tokenProposto);
        this.atividade = Atividade.ATIVO;
    }

    public void IniciarAlteracaoSenha(){
        if (this.emailValidacao.validado()) this.alteraSenha = AlteraSenha.Iniciar();
        else throw new FalhaValidacaoException("Necessário validar email primeiro");
    }

    public void RedefinirSenha(String tokenProposto, Senha novaSenha){
        if (tokenProposto == null) throw new FalhaValidacaoException();
            this.alteraSenha.Validar(tokenProposto);
            this.senhaBruta = novaSenha;
            this.alteraSenha = this.alteraSenha.Zerar();
    }

    public void DeletarUsuario() {
        this.atividade = Atividade.INATIVO;
    }

    public void atualizarCelular(Celular novoCelular) {
        if (novoCelular == null) throw new FalhaValidacaoException("Celular não pode ser nulo.");
        this.celular = novoCelular;
    }

    public void atualizarEmail(Email novoEmail) {
        this.email = novoEmail;
        this.emailValidacao = EmailValidacao.Iniciar();
    }

    public void atualizarEndereco(Endereco novoEndereco) {
        if (novoEndereco == null) throw new FalhaValidacaoException("Endereço não pode ser nulo.");
        this.endereco = novoEndereco;
    }

    public TextoValido getNome() {
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

    public Celular getCelular() {
        return celular;
    }

    public EmailValidacao getEmailValidacao() {
        return emailValidacao;
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

package br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Atividade;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.BaseUsuarioGeral;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.LinkedHashSet;

public class Responsavel extends BaseUsuarioGeral {

    private LinkedHashSet<Rm> rmsFilhos;

    public Responsavel(TextoValido nome, Cpf cpf, DataNascimento dataNasc, Email email, Endereco endereco, Celular celular, Atividade atividade, LinkedHashSet<Rm> rmsFilhos) {
        super(nome, cpf, dataNasc, email, endereco, celular, atividade);
        this.rmsFilhos = rmsFilhos;
    }

    public void adicionarRmFilho(LinkedHashSet<Rm> rmsFilhos) {
        this.rmsFilhos.addAll(rmsFilhos);
    }

    public LinkedHashSet<Rm> getRmsFilhos() {
        return rmsFilhos;
    }
}

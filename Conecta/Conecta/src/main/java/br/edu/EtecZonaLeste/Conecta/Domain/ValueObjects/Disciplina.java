package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

public record Disciplina(
        TextoValido nomeDisciplina,
        NumeroNatural quantidadeAulasTotal,
        NumeroNatural quantidadeAulasDadas
) {

}

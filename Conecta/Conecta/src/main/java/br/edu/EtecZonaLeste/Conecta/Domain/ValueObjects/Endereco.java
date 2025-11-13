package br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects;

public record Endereco(

        Cep cep,
        String logradouro,
        NumeroEndereco numero,
        String complemento,
        String bairro,
        String cidade,
        String estado
) {}

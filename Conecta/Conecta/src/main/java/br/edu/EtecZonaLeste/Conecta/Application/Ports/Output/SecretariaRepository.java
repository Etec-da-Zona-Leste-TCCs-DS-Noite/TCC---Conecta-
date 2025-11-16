package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;
import java.util.Optional;

public interface SecretariaRepository {

    void SalvarSecretaria(Secretaria secretaria);
    Optional<Secretaria> RetornoSecretariaPorCpf(Cpf cpf);
    List<Secretaria> RetornoSecretariaPorNome(Integer pages, Integer size, TextoValido nome);
    List<Secretaria> RetornoSecretaria(Integer pages, Integer size);
    List<Secretaria> RetornoSecretariaPorNomeInativos(TextoValido nome);
    List<Secretaria> RetornoSecretariaInativos(Integer pages, Integer size);
}

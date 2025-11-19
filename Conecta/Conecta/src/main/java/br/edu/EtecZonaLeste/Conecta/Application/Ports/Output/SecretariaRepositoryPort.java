package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Secretaria.Secretaria;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;
import java.util.Optional;

public interface SecretariaRepositoryPort {

    void SalvarSecretaria(Secretaria secretaria);
    Optional<Secretaria> RetornoSecretariaPorCpf(Cpf cpf);
    List<Secretaria> RetornoSecretariaPorNome(Integer pages, Integer size, TextoValido nome);
    List<Secretaria> RetornoSecretaria(Integer pages, Integer size);
}

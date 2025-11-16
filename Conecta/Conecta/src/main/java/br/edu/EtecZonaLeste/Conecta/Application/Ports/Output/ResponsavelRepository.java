package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

public interface ResponsavelRepository {

    void SalvarResponsavel(Responsavel responsavel);
    Optional<Responsavel> RetornoResponsavelPorCpf(Cpf cpf);
    List<Responsavel> RetornoResponsaveis(Integer pages, Integer size);
    List<Responsavel> RetornoResponsaveisPorNome(Integer pages, Integer size, TextoValido nome);
    List<Responsavel> RetornoResponsaveisPorFilhos(LinkedHashSet<Rm> rmsFilhos);
}

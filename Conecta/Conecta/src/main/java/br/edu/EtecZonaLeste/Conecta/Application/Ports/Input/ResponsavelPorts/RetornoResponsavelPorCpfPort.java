package br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTORetornoResponsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Responsavel.Responsavel;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;

import java.util.Optional;

public interface RetornoResponsavelPorCpfPort {

    Optional<DTORetornoResponsavel> RetornoResponsavelPorCpf(Cpf cpf);

}

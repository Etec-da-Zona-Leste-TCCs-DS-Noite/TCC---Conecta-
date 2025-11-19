package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cep;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.NumeroEndereco;

public interface CepServicePort {

    Endereco InsereEndereco(Cep cep, NumeroEndereco numeroEndereco);
}

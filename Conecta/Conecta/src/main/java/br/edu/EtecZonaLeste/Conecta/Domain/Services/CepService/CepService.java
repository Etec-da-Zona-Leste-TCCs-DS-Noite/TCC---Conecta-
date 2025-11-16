package br.edu.EtecZonaLeste.Conecta.Domain.Services.CepService;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cep;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.NumeroEndereco;

public interface CepService {

    Endereco InsereEndereco(Cep cep, NumeroEndereco numeroEndereco);
}

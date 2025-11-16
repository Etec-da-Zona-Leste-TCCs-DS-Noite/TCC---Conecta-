package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Celular;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Disciplina;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;

import java.util.List;

public record DTOAtualizacaoProfessor(

        Email email,
        DTOEndereco endereco,
        Celular celular,
        List<Disciplina> disciplinas,
        List<Periodo> periodos
) {
}

package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.List;

public record DTOCadastroProfessor(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNasc,
        Email email,
        DTOEndereco endereco,
        Celular celular,
        List<Disciplina> disciplinas,
        List<Periodo> periodos
) {
}

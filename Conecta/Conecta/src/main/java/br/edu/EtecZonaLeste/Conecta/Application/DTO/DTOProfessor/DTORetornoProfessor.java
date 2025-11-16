package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOProfessor;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.List;

public record DTORetornoProfessor(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNascimento,
        Email email,
        Endereco endereco,
        Celular celular,
        List<Disciplina> disciplinas,
        List<Periodo> periodos
) {
}

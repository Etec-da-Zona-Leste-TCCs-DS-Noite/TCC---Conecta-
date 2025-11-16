package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.BaseUsuarioGeral.Periodo;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.*;

import java.util.LinkedHashSet;

public record DTOCadastroAluno(

        TextoValido nome,
        Cpf cpf,
        DataNascimento dataNasc,
        Email email,
        DTOEndereco endereco,
        Celular celular,
        LinkedHashSet<Curso> cursos,
        Periodo periodo
) {
}

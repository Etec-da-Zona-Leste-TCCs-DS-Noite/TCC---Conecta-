package br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOEndereco.DTOEndereco;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Celular;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Curso;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Endereco;

import java.util.LinkedHashSet;

public record DTOAtualizacaoAluno(

        Email email,
        DTOEndereco endereco,
        Celular celular,
        LinkedHashSet<Curso> cursos
) {
}

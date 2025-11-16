package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.Entities.User.Professor.Professor;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Cpf;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {

    void SalvarProfessor(Professor professor);
    Optional<Professor> RetornoProfessorPorCpf(Cpf cpf);
    List<Professor> RetornoProfessores(Integer pages, Integer size);
    List<Professor> RetornoProfessoresPorNome(Integer pages, Integer size, TextoValido nome);
}

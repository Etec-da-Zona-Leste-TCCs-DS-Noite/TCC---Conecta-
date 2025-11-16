package br.edu.EtecZonaLeste.Conecta.Application.Services;

import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ChatMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class BuscaMensageiroService {

    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final ResponsavelRepository responsavelRepository;
    private final ChatMapper mapper;

    public BuscaMensageiroService(AlunoRepository alunoRepository, ProfessorRepository professorRepository, ResponsavelRepository responsavelRepository, ChatMapper mapper) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.responsavelRepository = responsavelRepository;
        this.mapper = mapper;
    }

    public TipoMensageiro BuscaTipoMensageiro(String id) {

        var aluno = alunoRepository.RetornoAlunoPorRm(mapper.mapStringToRm(id));
        if (aluno.isPresent()) return TipoMensageiro.ALUNO;

        var professor = professorRepository.RetornoProfessorPorCpf(mapper.mapStringToCpf(id));
        if (professor.isPresent()) return TipoMensageiro.PROFESSOR;

        var responsavel = responsavelRepository.RetornoResponsavelPorCpf(mapper.mapStringToCpf(id));
        if (responsavel.isPresent()) return TipoMensageiro.RESPONSAVEL;

        if (id.equals("SECRETARIA")) return TipoMensageiro.SECRETARIA;

        throw new DadoInvalidoException();
    }
}

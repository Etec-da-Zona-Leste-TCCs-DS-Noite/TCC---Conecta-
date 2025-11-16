package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ChatUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem.DTOMensagem;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ChatMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ChatPorts.EnviarMensagemPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ChatRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ProfessorRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Services.BuscaMensageiroService;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.Mensagem;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.ConteudoInapropriadoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Services.IAService.IAService;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

public class EnviarMensagemUseCase implements EnviarMensagemPort {

    private final IAService iaService;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final ResponsavelRepository responsavelRepository;
    private final ChatMapper mapper;
    private final ChatRepository repository;
    private final BuscaMensageiroService buscaMensageiroService;

    public EnviarMensagemUseCase(IAService iaService, AlunoRepository alunoRepository, ProfessorRepository professorRepository, ResponsavelRepository responsavelRepository, ChatMapper mapper, ChatRepository repository, BuscaMensageiroService buscaMensageiroService) {
        this.iaService = iaService;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.responsavelRepository = responsavelRepository;
        this.mapper = mapper;
        this.repository = repository;
        this.buscaMensageiroService = buscaMensageiroService;
    }


    @Override
    public void EnviarMensagem(DTOMensagem dto) {
        var tipoRemetente = buscaMensageiroService.BuscaTipoMensageiro(dto.idMensageiro());
        var tipoDestinatario = buscaMensageiroService.BuscaTipoMensageiro(dto.idDestinatario());
        iaService.verificarConteudoInadequado(dto.mensagem());
        if (iaService.verificarConteudoInadequado(dto.mensagem())) throw new ConteudoInapropriadoException();
        else {
            switch (tipoRemetente) {
                case ALUNO:
                    var aluno = alunoRepository
                            .RetornoAlunoPorRm(mapper.mapStringToRm(dto.idMensageiro()))
                            .orElseThrow(() -> new DadoInvalidoException("Aluno não encontrado."));
                    var nome = aluno.getNome();
                    switch (tipoDestinatario) {
                        case PROFESSOR:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nome, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case SECRETARIA:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nome, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        default:
                            throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de aluno.");
                    }
                    break;
                case PROFESSOR:
                    var professor = professorRepository
                            .RetornoProfessorPorCpf(mapper.mapStringToCpf(dto.idMensageiro()))
                            .orElseThrow(() -> new DadoInvalidoException("Professor não encontrado."));
                    var nomeProf = professor.getNome();
                    switch (tipoDestinatario) {
                        case ALUNO:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeProf, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case SECRETARIA:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeProf, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        default:
                            throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de professor.");
                    }
                    break;
                case RESPONSAVEL:
                    var responsavel = responsavelRepository
                            .RetornoResponsavelPorCpf(mapper.mapStringToCpf(dto.idMensageiro()))
                            .orElseThrow(() -> new DadoInvalidoException("Responsável não encontrado."));
                    var nomeResp = responsavel.getNome();
                    if (tipoDestinatario == TipoMensageiro.SECRETARIA) {
                        repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeResp, dto.mensagem(), tipoRemetente, tipoDestinatario));
                    } else {
                        throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de responsável.");
                    }
                    break;
                case SECRETARIA:
                    TextoValido nomeSec = new TextoValido("Secretaria");
                    switch (tipoDestinatario) {
                        case ALUNO:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeSec, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case PROFESSOR:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeSec, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case RESPONSAVEL:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeSec, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        default:
                            throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de secretaria.");
                    }
                    break;
                default:
                    throw new DadoInvalidoException("Tipo de remetente inválido.");
            }
        }
    }
}
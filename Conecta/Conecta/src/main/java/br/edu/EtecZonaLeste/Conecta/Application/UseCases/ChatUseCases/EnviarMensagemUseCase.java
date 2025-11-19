package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ChatUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOMensagem.DTOMensagem;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ChatMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ChatPorts.EnviarMensagemPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.*;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.Mensagem;
import br.edu.EtecZonaLeste.Conecta.Domain.Entities.Chat.TipoMensageiro;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.ConteudoInapropriadoException;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.TextoValido;

public class EnviarMensagemUseCase implements EnviarMensagemPort {

    private final IAServicePort iaServicePort;
    private final EmailServicePort emailServicePort;
    private final AlunoRepositoryPort alunoRepositoryPort;
    private final ProfessorRepositoryPort professorRepositoryPort;
    private final ResponsavelRepositoryPort responsavelRepositoryPort;
    private final ChatMapper mapper;
    private final ChatRepositoryPort repository;

    public EnviarMensagemUseCase(IAServicePort iaServicePort, EmailServicePort emailServicePort, AlunoRepositoryPort alunoRepositoryPort, ProfessorRepositoryPort professorRepositoryPort, ResponsavelRepositoryPort responsavelRepositoryPort, ChatMapper mapper, ChatRepositoryPort repository) {
        this.iaServicePort = iaServicePort;
        this.emailServicePort = emailServicePort;
        this.alunoRepositoryPort = alunoRepositoryPort;
        this.professorRepositoryPort = professorRepositoryPort;
        this.responsavelRepositoryPort = responsavelRepositoryPort;
        this.mapper = mapper;
        this.repository = repository;
    }

    private TipoMensageiro BuscaTipoMensageiro(String id) {

        var aluno = alunoRepositoryPort.RetornoAlunoPorRm(mapper.mapStringToRm(id));
        if (aluno.isPresent()) return TipoMensageiro.ALUNO;

        var professor = professorRepositoryPort.RetornoProfessorPorCpf(mapper.mapStringToCpf(id));
        if (professor.isPresent()) return TipoMensageiro.PROFESSOR;

        var responsavel = responsavelRepositoryPort.RetornoResponsavelPorCpf(mapper.mapStringToCpf(id));
        if (responsavel.isPresent()) return TipoMensageiro.RESPONSAVEL;

        if (id.equals("SECRETARIA")) return TipoMensageiro.SECRETARIA;

        throw new DadoInvalidoException();
    }

    @Override
    public void EnviarMensagem(DTOMensagem dto) {
        var tipoRemetente = BuscaTipoMensageiro(dto.idMensageiro());
        var tipoDestinatario = BuscaTipoMensageiro(dto.idDestinatario());
        Email email = null;
        TextoValido nomeRemetente = null;
        TextoValido nomeDestinatario = null;
        iaServicePort.verificarConteudoInadequado(dto.mensagem());
        if (iaServicePort.verificarConteudoInadequado(dto.mensagem())) throw new ConteudoInapropriadoException();
        else {
            switch (tipoRemetente) {
                case ALUNO:
                    var aluno = alunoRepositoryPort
                            .RetornoAlunoPorRm(mapper.mapStringToRm(dto.idMensageiro()))
                            .orElseThrow(() -> new DadoInvalidoException("Aluno não encontrado."));
                    nomeRemetente = aluno.getNome();
                    email = aluno.getEmail();
                    switch (tipoDestinatario) {
                        case PROFESSOR:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case SECRETARIA:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        default:
                            throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de aluno.");
                    }
                    break;
                case PROFESSOR:
                    var professor = professorRepositoryPort
                            .RetornoProfessorPorCpf(mapper.mapStringToCpf(dto.idMensageiro()))
                            .orElseThrow(() -> new DadoInvalidoException("Professor não encontrado."));
                    nomeRemetente = professor.getNome();
                    email = professor.getEmail();
                    switch (tipoDestinatario) {
                        case ALUNO:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case SECRETARIA:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        default:
                            throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de professor.");
                    }
                    break;
                case RESPONSAVEL:
                    var responsavel = responsavelRepositoryPort
                            .RetornoResponsavelPorCpf(mapper.mapStringToCpf(dto.idMensageiro()))
                            .orElseThrow(() -> new DadoInvalidoException("Responsável não encontrado."));
                    nomeRemetente = responsavel.getNome();
                    email = responsavel.getEmail();
                    if (tipoDestinatario == TipoMensageiro.SECRETARIA) {
                        repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                    } else {
                        throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de responsável.");
                    }
                    break;
                case SECRETARIA:
                    nomeRemetente = new TextoValido("Secretaria");
                    email = new Email("emailoficialdasecretaria@gmail.com");
                    switch (tipoDestinatario) {
                        case ALUNO:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case PROFESSOR:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        case RESPONSAVEL:
                            repository.EnviarMensagem(new Mensagem(dto.idMensageiro(), dto.idDestinatario(), nomeRemetente, dto.mensagem(), tipoRemetente, tipoDestinatario));
                            break;
                        default:
                            throw new DadoInvalidoException("Tipo de remetente inválido para mensagem de secretaria.");
                    }
                    break;
                default:
                    throw new DadoInvalidoException("Tipo de remetente inválido.");
            }
            emailServicePort.NotificarMensagem(email, dto.mensagem());
        }
    }
}
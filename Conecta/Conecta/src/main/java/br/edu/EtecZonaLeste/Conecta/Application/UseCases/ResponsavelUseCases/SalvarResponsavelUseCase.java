package br.edu.EtecZonaLeste.Conecta.Application.UseCases.ResponsavelUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOResponsavel.DTOCadastroResponsavel;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.ResponsavelMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.ResponsavelPorts.SalvarResponsavelPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.ResponsavelRepository;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnvioValidacaoEmailService;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;
import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Rm;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class SalvarResponsavelUseCase implements SalvarResponsavelPort {

    private final ResponsavelRepository repository;
    private final AlunoRepository alunoRepository;
    private final EnvioValidacaoEmailService service;
    private final ResponsavelMapper mapper;

    public SalvarResponsavelUseCase(ResponsavelRepository repository, AlunoRepository alunoRepository, EnvioValidacaoEmailService service, ResponsavelMapper mapper) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.service = service;
        this.mapper = mapper;
    }

    private void ValidaVinculacaoAluno(LinkedHashSet<Rm> rmsFilhos) {
        for (Rm rm : rmsFilhos) {
            var retornoAluno = alunoRepository.RetornoAlunoPorRm(rm)
                    .orElse(null);
            if (retornoAluno == null) throw new DadoInvalidoException("Aluno com RM " + rm + " não encontrado.");
            if (retornoAluno.getDataNasc().dataNascimento().isBefore(LocalDate.now().minusYears(18))) {
                throw new DadoInvalidoException("Aluno com RM " + rm + " é maior de idade e não pode ser vinculado a um responsável.");
            }
        }
    }

    @Override
    public void SalvarResponsavel(DTOCadastroResponsavel dto) {
        var retorno = repository.RetornoResponsavelPorCpf(dto.cpf())
                .orElse(null);
        if (retorno == null) {
            ValidaVinculacaoAluno(dto.rmsFilhos());
            var responsavel = mapper.toRegister(dto);
            service.EnviarPropostaDeValidacaoEmail(responsavel.getEmailValidacao().token(), responsavel.getEmail());
            repository.SalvarResponsavel(responsavel);
        }
        else if (retorno != null && !dto.rmsFilhos().equals(retorno.getRmsFilhos())){
            ValidaVinculacaoAluno(dto.rmsFilhos());
            retorno.adicionarRmFilho(dto.rmsFilhos());
        }
        else if (retorno != null && dto.rmsFilhos().equals(retorno.getRmsFilhos())){
            throw new DadoInvalidoException("Responsável já cadastrado.");
        }
    }
}

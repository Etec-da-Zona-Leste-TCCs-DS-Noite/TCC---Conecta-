package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOCadastroAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.SalvarAlunoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepositoryPort;
import br.edu.EtecZonaLeste.Conecta.Application.Services.EnvioValidacaoEmailService;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class SalvarAlunoUseCase implements SalvarAlunoPort {

    private final AlunoRepositoryPort repository;
    private final AlunoMapper mapper;
    private final EnvioValidacaoEmailService service;

    public SalvarAlunoUseCase(AlunoRepositoryPort repository, AlunoMapper mapper, EnvioValidacaoEmailService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }

    @Override
    public void SalvarAluno(DTOCadastroAluno dto) {
        var retorno = (repository.RetornoAlunoPorCpf(dto.cpf())).get();
        if (retorno != null && dto.cursos() == retorno.getCursos()) throw new DadoInvalidoException("Aluno ja presente");
        else if (retorno != null && dto.cursos() != retorno.getCursos()){
            retorno.AddCurso(dto.cursos());
            repository.SalvarAluno(retorno);
        } else {
            var alunoParaSalvar = mapper.toRegister(dto);
            service.EnviarPropostaDeValidacaoEmail(alunoParaSalvar.getEmailValidacao().token(), alunoParaSalvar.getEmail());
            repository.SalvarAluno(alunoParaSalvar);
        }
    }
}

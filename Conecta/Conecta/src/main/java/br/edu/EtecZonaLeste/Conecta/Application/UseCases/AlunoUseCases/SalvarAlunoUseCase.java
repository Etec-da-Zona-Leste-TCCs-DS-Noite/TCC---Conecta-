package br.edu.EtecZonaLeste.Conecta.Application.UseCases.AlunoUseCases;

import br.edu.EtecZonaLeste.Conecta.Application.DTO.DTOAluno.DTOCadastroAluno;
import br.edu.EtecZonaLeste.Conecta.Application.Mappers.AlunoMapper;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Input.AlunoPorts.SalvarAlunoPort;
import br.edu.EtecZonaLeste.Conecta.Application.Ports.Output.AlunoRepository;
import br.edu.EtecZonaLeste.Conecta.Domain.Exceptions.Exceptions.DadoInvalidoException;

public class SalvarAlunoUseCase implements SalvarAlunoPort {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;

    public SalvarAlunoUseCase(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void SalvarAluno(DTOCadastroAluno dto) {
        var retorno = (repository.RetornoAlunoPorCpf(dto.cpf())).get();
        if (retorno != null && dto.cursos() == retorno.getCursos()) throw new DadoInvalidoException("Aluno ja presente");
        else if (retorno != null && dto.cursos() != retorno.getCursos()){
            retorno.AddCurso(dto.cursos());
            repository.SalvarAluno(retorno);
        } else {
            repository.SalvarAluno(mapper.toRegister(dto));
        }
    }
}

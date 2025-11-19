package br.edu.EtecZonaLeste.Conecta.Application.Ports.Output;

import br.edu.EtecZonaLeste.Conecta.Domain.ValueObjects.Email;

import java.util.List;

public interface EmailServicePort {

    void EnviarEmailAutenticacao(Email emailDestinatario, String token);

    void EnviarEmailAlteracaoSenha(Email emailDestinatario, String token);

    void NotificarAviso(List<Email> emailDestinatarios, String titulo, String conteudo);

    void NotificarMensagem(Email emailDestinatarios, String conteudo);
}

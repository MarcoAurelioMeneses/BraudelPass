package br.org.braudel.braudelPass.principal;

import br.org.braudel.braudelPass.models.Senhas;
import br.org.braudel.braudelPass.repositorios.SenhasRepositorios;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final SenhasRepositorios repositorio;
    private Scanner entraDados = new Scanner(System.in);

    public Principal(SenhasRepositorios repositorio) {
        this.repositorio = repositorio;
    }

    public void ExibirMenu() {
        var opcao = -1;

        while (opcao!=0){
            var menu = """
                    SELECIONE UMA OPÇÃO ABAIXO PARA INICIAR O PROGRAMA:
                    
                    1 - Adicionar uma senha
                    2 - Consultar uma senha
                    3 - Listar senhas
                    0 - Finalizar sessão
                    """;

            System.out.println(menu);
            opcao = entraDados.nextInt();
            entraDados.nextLine();

            switch (opcao){
                case 1:
                    adiconarSenha();
                    break;
                case 2:
                    consultarSenha();
                    break;
                case 3:
                    listarSenha();
                case 0:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }

    private void adiconarSenha() {
        var cadastrarNovaSenha = "Sim";

        while (cadastrarNovaSenha.equalsIgnoreCase("Sim")){
            System.out.println("Informe a identificação do acesso: ");
            var identificacao = entraDados.nextLine();
            System.out.println("Informe qual o usuario do acesso: ");
            var usuario = entraDados.nextLine();
            System.out.println("Informe qual a senha do acesso: ");
            var senha = entraDados.nextLine();
            System.out.println("Digite a descrição da acesso: ");
            var descricao = entraDados.nextLine();
            Senhas senhas = new Senhas(identificacao, usuario, senha, descricao);
            repositorio.save(senhas);
            System.out.println("Deseja cadatrar nova senha? (Sim/Não)");
            cadastrarNovaSenha = entraDados.nextLine();
        }

    }

    private void consultarSenha() {
        System.out.println("Procurar uma senha: ");
        var nome = entraDados.nextLine();
        List<Senhas> senhas = repositorio.buscarSenhas(nome);
        senhas.forEach(System.out::println);
    }

    private void listarSenha() {
        List<Senhas> senhas = repositorio.findAll();
        senhas.forEach(System.out::println);
    }
}


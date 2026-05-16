package br.com.fiapbank.presentation;

import br.com.fiapbank.application.ContaService;
import br.com.fiapbank.model.entity.Conta;
import br.com.fiapbank.model.valueobject.Movimentacao;

import java.util.List;
import java.util.Scanner;

/**
 * Camada de apresentação.
 * Responsável pela interação com o usuário.
 */
public class Menu {

    private final Scanner scanner;

    private final ContaService contaService;

    public Menu() {

        this.scanner = new Scanner(System.in);

        this.contaService = new ContaService();
    }

    public void iniciar(Conta conta) {

        System.out.println("=================================");
        System.out.println("FIAP BANK ATM");
        System.out.println("=================================");

        System.out.print("Digite sua senha: ");

        String senha = scanner.nextLine();

        Boolean autenticado = conta.getCliente()
                .getContaAcesso()
                .autenticar(senha);

        if (!autenticado) {

            System.out.println("Senha incorreta.");

            return;
        }

        Boolean continuar = true;

        while (continuar) {

            System.out.println("\n========== MENU ==========");
            System.out.println("[1] Consultar Saldo");
            System.out.println("[2] Fazer Deposito");
            System.out.println("[3] Fazer Saque");
            System.out.println("[4] Historico");
            System.out.println("[5] Sair");

            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            switch (opcao) {

                case "1":

                    System.out.println(
                            "Saldo atual: R$ "
                                    + conta.getSaldo().getValor()
                    );

                    break;

                case "2":

                    System.out.print("Valor do deposito: ");

                    String deposito = scanner.nextLine();

                    try {

                        contaService.depositar(conta, deposito);

                        System.out.println("Deposito realizado.");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case "3":

                    System.out.print("Valor do saque: ");

                    String saque = scanner.nextLine();

                    try {

                        contaService.sacar(conta, saque);

                        System.out.println("Saque realizado.");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case "4":

                    List<Movimentacao> movimentacoes =
                            conta.getMovimentacoes();

                    System.out.println("\n====== HISTORICO ======");

                    for (Movimentacao movimentacao : movimentacoes) {

                        System.out.println(
                                movimentacao.getDataHora()
                                        + " | "
                                        + movimentacao.getTipo()
                                        + " | R$ "
                                        + movimentacao.getValor().getValor()
                        );
                    }

                    break;

                case "5":

                    continuar = false;

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }
        }
    }
}
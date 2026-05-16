package br.com.fiapbank.application;

import br.com.fiapbank.infrastructure.ContaRepository;
import br.com.fiapbank.model.entity.Cliente;
import br.com.fiapbank.model.entity.Conta;
import br.com.fiapbank.model.valueobject.ContaAcesso;
import br.com.fiapbank.presentation.Menu;

/**
 * Classe principal do sistema.
 * Responsável por iniciar o FIAP Bank ATM.
 */
public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Lucas Abat",
                new ContaAcesso("1234")
        );

        Conta conta = ContaFactory.criarContaCorrente(cliente);

        ContaRepository.getInstance().salvarConta(conta);

        Menu menu = new Menu();

        menu.iniciar(conta);
    }
}
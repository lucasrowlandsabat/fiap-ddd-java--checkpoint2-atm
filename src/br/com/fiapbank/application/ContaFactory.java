package br.com.fiapbank.application;

import br.com.fiapbank.model.entity.Cliente;
import br.com.fiapbank.model.entity.Conta;
import br.com.fiapbank.model.entity.ContaCorrente;
import br.com.fiapbank.model.entity.ContaPoupanca;

/**
 * Factory responsável pela criaçao das contas.
 */
public class ContaFactory {

    private ContaFactory() {
    }

    public static Conta criarContaCorrente(Cliente cliente) {
        return new ContaCorrente(cliente);
    }

    public static Conta criarContaPoupanca(Cliente cliente) {
        return new ContaPoupanca(cliente);
    }
}
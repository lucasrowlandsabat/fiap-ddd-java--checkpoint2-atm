package br.com.fiapbank.application;

import br.com.fiapbank.model.entity.Conta;
import br.com.fiapbank.model.valueobject.Dinheiro;

/**
 * Camada de aplicação responsável
 * por operações da conta.
 */
public class ContaService {

    public void depositar(Conta conta, String valor) {

        conta.depositar(new Dinheiro(valor));
    }

    public void sacar(Conta conta, String valor) {

        conta.realizarSaque(new Dinheiro(valor));
    }
}
package br.com.fiapbank.model.entity;

import br.com.fiapbank.model.valueobject.Dinheiro;
import br.com.fiapbank.model.valueobject.Movimentacao;

/**
 * Conta Poupança.
 */
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {

        super(cliente);
    }

    @Override
    protected void aplicarRegraDeTaxa() {

    }

    public void renderJuros() {

        Dinheiro rendimento =
                new Dinheiro("10");

        saldo = saldo.somar(rendimento);

        movimentacoes.add(
                new Movimentacao(
                        "RENDIMENTO",
                        rendimento
                )
        );
    }
}
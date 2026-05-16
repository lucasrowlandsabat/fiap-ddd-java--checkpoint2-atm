package br.com.fiapbank.model.entity;

import br.com.fiapbank.model.valueobject.Dinheiro;
import br.com.fiapbank.model.valueobject.Movimentacao;

/**
 * Conta Corrente.
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {

        super(cliente);
    }

    @Override
    protected void aplicarRegraDeTaxa() {

        Dinheiro taxa = new Dinheiro("5");

        saldo = saldo.subtrair(taxa);

        movimentacoes.add(
                new Movimentacao(
                        "TAXA",
                        taxa
                )
        );
    }
}
package br.com.fiapbank.model.entity;

import br.com.fiapbank.model.valueobject.Dinheiro;
import br.com.fiapbank.model.valueobject.Movimentacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe abstrata de Conta.
 * Implementa Template Method para saque.
 */
public abstract class Conta extends BaseEntity {

    protected Dinheiro saldo;

    protected final Cliente cliente;

    protected final List<Movimentacao> movimentacoes;

    public Conta(Cliente cliente) {

        this.cliente = cliente;

        this.saldo = new Dinheiro("0");

        this.movimentacoes = new ArrayList<>();
    }

    public void depositar(Dinheiro valor) {

        validarValor(valor);

        saldo = saldo.somar(valor);

        movimentacoes.add(
                new Movimentacao(
                        "DEPOSITO",
                        valor
                )
        );
    }

    /**
     * Template Method.
     */
    public void realizarSaque(Dinheiro valor) {

        validarValor(valor);

        if (saldo.menorQue(valor)) {

            throw new IllegalArgumentException(
                    "Saldo insuficiente."
            );
        }

        saldo = saldo.subtrair(valor);

        movimentacoes.add(
                new Movimentacao(
                        "SAQUE",
                        valor
                )
        );

        aplicarRegraDeTaxa();
    }

    protected abstract void aplicarRegraDeTaxa();

    private void validarValor(Dinheiro valor) {

        if (valor.getValor()
                .compareTo(valor.zero()) <= 0) {

            throw new IllegalArgumentException(
                    "Valor invalido."
            );
        }
    }

    public Dinheiro getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Conta)) {
            return false;
        }

        Conta other = (Conta) obj;

        return Objects.equals(cliente, other.cliente);
    }
}
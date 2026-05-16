package br.com.fiapbank.model.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Value Object monetário.
 */
public class Dinheiro {

    private final BigDecimal valor;

    public Dinheiro(String valor) {

        this.valor = new BigDecimal(valor);
    }

    public Dinheiro(BigDecimal valor) {

        this.valor = valor;
    }

    public Dinheiro somar(
            Dinheiro outroValor
    ) {

        return new Dinheiro(
                valor.add(
                        outroValor.getValor()
                )
        );
    }

    public Dinheiro subtrair(
            Dinheiro outroValor
    ) {

        return new Dinheiro(
                valor.subtract(
                        outroValor.getValor()
                )
        );
    }

    public Boolean menorQue(
            Dinheiro outroValor
    ) {

        return valor.compareTo(
                outroValor.getValor()
        ) < 0;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal zero() {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Dinheiro)) {
            return false;
        }

        Dinheiro other =
                (Dinheiro) obj;

        return Objects.equals(
                valor,
                other.valor
        );
    }
}
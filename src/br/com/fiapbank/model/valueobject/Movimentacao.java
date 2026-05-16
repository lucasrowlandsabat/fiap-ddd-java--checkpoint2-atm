package br.com.fiapbank.model.valueobject;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object de movimentação.
 */
public class Movimentacao {

    private final LocalDateTime dataHora;

    private final String tipo;

    private final Dinheiro valor;

    public Movimentacao(
            String tipo,
            Dinheiro valor
    ) {

        this.dataHora = LocalDateTime.now();

        this.tipo = tipo;

        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public Dinheiro getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Movimentacao)) {
            return false;
        }

        Movimentacao other =
                (Movimentacao) obj;

        return Objects.equals(
                dataHora,
                other.dataHora
        );
    }
}
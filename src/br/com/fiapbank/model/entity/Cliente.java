package br.com.fiapbank.model.entity;

import br.com.fiapbank.model.valueobject.ContaAcesso;

import java.util.Objects;

/**
 * Entidade Cliente.
 */
public class Cliente extends BaseEntity {

    private final String nomeCompleto;

    private final ContaAcesso contaAcesso;

    public Cliente(
            String nomeCompleto,
            ContaAcesso contaAcesso
    ) {

        if (nomeCompleto == null || nomeCompleto.isBlank()) {

            throw new IllegalArgumentException(
                    "Nome invalido."
            );
        }

        this.nomeCompleto = nomeCompleto;

        this.contaAcesso = contaAcesso;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ContaAcesso getContaAcesso() {
        return contaAcesso;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cliente)) {
            return false;
        }

        Cliente other = (Cliente) obj;

        return Objects.equals(
                nomeCompleto,
                other.nomeCompleto
        );
    }
}
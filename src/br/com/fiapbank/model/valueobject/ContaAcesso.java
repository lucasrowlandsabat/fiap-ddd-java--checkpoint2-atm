package br.com.fiapbank.model.valueobject;

import java.util.Objects;

/**
 * Value Object de acesso da conta.
 */
public class ContaAcesso {

    private final String senha;

    public ContaAcesso(String senha) {

        this.senha = senha;
    }

    public Boolean autenticar(
            String senhaDigitada
    ) {

        return senha.equals(senhaDigitada);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContaAcesso)) {
            return false;
        }

        ContaAcesso other =
                (ContaAcesso) obj;

        return Objects.equals(
                senha,
                other.senha
        );
    }
}

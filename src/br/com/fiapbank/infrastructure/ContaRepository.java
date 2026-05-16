package br.com.fiapbank.infrastructure;

import br.com.fiapbank.model.entity.Conta;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository em memória.
 * Implementa Singleton.
 */
public class ContaRepository {

    private static ContaRepository instance;

    private final List<Conta> contas;

    private ContaRepository() {

        this.contas = new ArrayList<>();
    }

    public static ContaRepository getInstance() {

        if (instance == null) {
            instance = new ContaRepository();
        }

        return instance;
    }

    public void salvarConta(Conta conta) {

        contas.add(conta);
    }

    public List<Conta> listarContas() {

        return contas;
    }
}

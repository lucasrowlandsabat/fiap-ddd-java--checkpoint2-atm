package br.com.fiapbank.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe base para entidades do domínio.
 */
public abstract class BaseEntity {

    private final UUID id;

    private final LocalDate dataCriacao;

    public BaseEntity() {

        this.id = UUID.randomUUID();

        this.dataCriacao = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BaseEntity)) {
            return false;
        }

        BaseEntity other = (BaseEntity) obj;

        return Objects.equals(id, other.id);
    }
}
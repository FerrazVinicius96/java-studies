package model.entities;

import java.util.Objects;

public abstract class Equipamento {

    private final Integer idEquipamento;
    private final String nome;
    private final String marca;

    public Equipamento(Integer idEquipamento, String nome, String marca) {
        this.idEquipamento = idEquipamento;
        this.nome = nome;
        this.marca = marca;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    // Método abstrato: força cada subclasse a descrever sua capacidade específica.
    public abstract String getDescricaoCapacidade();

    // Método abstrato: força cada subclasse a informar seu tipo textual.
    public abstract String getTipo();

    // equals e hashCode baseados no ID, que é o identificador único de negócio.
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Equipamento))
            return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(idEquipamento, that.idEquipamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento);
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Nome: %-20s | Marca: %-15s | Tipo: %-10s | Capacidade: %s",
                idEquipamento, nome, marca, getTipo(), getDescricaoCapacidade());
    }
}
package model.repositories;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import model.entities.Equipamento;

public class RepositorioEquipamento {

    // LinkedHashSet mantém a ordem de inserção, melhor para relatórios.
    private final Set<Equipamento> equipamentos = new LinkedHashSet<>();

    public void add(Equipamento e) {
        equipamentos.add(e);
    }

    public void remove(Equipamento e) {
        equipamentos.remove(e);
    }

    public boolean contains(Equipamento e) {
        return equipamentos.contains(e);
    }

    public Set<Equipamento> findAll() {
        return Collections.unmodifiableSet(equipamentos);
    }
}